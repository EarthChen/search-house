package com.earthchen.spring.boot.searchhouse.web.controller.admin;

import com.earthchen.spring.boot.searchhouse.domain.SupportAddress;
import com.earthchen.spring.boot.searchhouse.enums.ResultEnum;
import com.earthchen.spring.boot.searchhouse.service.ServiceMultiResult;
import com.earthchen.spring.boot.searchhouse.service.ServiceResult;
import com.earthchen.spring.boot.searchhouse.service.house.IAddressService;
import com.earthchen.spring.boot.searchhouse.service.house.IHouseService;
import com.earthchen.spring.boot.searchhouse.service.house.IQiNiuService;
import com.earthchen.spring.boot.searchhouse.web.dto.*;
import com.earthchen.spring.boot.searchhouse.web.form.DatatableSearchForm;
import com.earthchen.spring.boot.searchhouse.web.form.HouseForm;
import com.earthchen.spring.boot.searchhouse.web.vo.ApiDataTableVO;
import com.earthchen.spring.boot.searchhouse.web.vo.ResultVO;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import lombok.extern.slf4j.Slf4j;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * 管理员控制器
 *
 * @author: EarthChen
 * @date: 2018/03/13
 */
@RequestMapping("/admin")
@Controller
@Slf4j
public class AdminController {

    @Autowired
    private Gson gson;

    @Autowired
    private IQiNiuService qiNiuService;

    @Autowired
    private IHouseService houseService;

    @Autowired
    private IAddressService addressService;

    /**
     * 后台管理中心
     *
     * @return
     */
    @GetMapping("/center")
    public String adminCenterPage() {
        return "admin/center";
    }

    /**
     * 欢迎页
     *
     * @return
     */
    @GetMapping("/welcome")
    public String welcomePage() {
        return "admin/welcome";
    }

    /**
     * 管理员登录页
     *
     * @return
     */
    @GetMapping("/login")
    public String adminLoginPage() {
        return "admin/login";
    }

    /**
     * 房源列表页
     *
     * @return
     */
    @GetMapping("/house/list")
    public String houseListPage() {
        return "admin/house-list";
    }

    @GetMapping("/add/house")
    public String addHousePage() {
        return "admin/house-add";
    }

    /**
     * 分页显示
     * <p>
     * 查询
     *
     * @param searchBody
     * @return
     */
    @PostMapping("/houses")
    @ResponseBody
    public ApiDataTableVO houses(@ModelAttribute DatatableSearchForm searchBody) {
        ServiceMultiResult<HouseDTO> result = houseService.adminQuery(searchBody);

        ApiDataTableVO response = new ApiDataTableVO(ResultEnum.SUCCESS);
        response.setData(result.getResult());
        response.setRecordsFiltered(result.getTotal());
        response.setRecordsTotal(result.getTotal());

        response.setDraw(searchBody.getDraw());
        return response;
    }


    /**
     * 新增房源接口
     *
     * @param houseForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/add/house")
    @ResponseBody
    public ResultVO addHouse(@Valid @ModelAttribute("form-house-add") HouseForm houseForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResultVO(HttpStatus.BAD_REQUEST.value(), bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
        }

        if (houseForm.getPhotos() == null || houseForm.getCover() == null) {
            return ResultVO.ofMessage(HttpStatus.BAD_REQUEST.value(), "必须上传图片");
        }

        Map<SupportAddress.Level, SupportAddressDTO> addressMap = addressService.findCityAndRegion(houseForm.getCityEnName(), houseForm.getRegionEnName());
        if (addressMap.keySet().size() != 2) {
            return ResultVO.ofStatus(ResultEnum.NOT_VALID_PARAM);
        }

        ServiceResult<HouseDTO> result = houseService.save(houseForm);
        if (result.isSuccess()) {
            return ResultVO.ofSuccess(result.getResult());
        }

        return ResultVO.ofSuccess(ResultEnum.NOT_VALID_PARAM);
    }

    /**
     * 上传图片接口
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/upload/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResultVO uploadPhoto(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultVO.ofStatus(ResultEnum.NOT_VALID_PARAM);
        }

        String fileName = file.getOriginalFilename();
        log.info(fileName);

        try {
            InputStream inputStream = file.getInputStream();
            Response response = qiNiuService.uploadFile(inputStream);
            if (response.isOK()) {
                QiNiuPutRet ret = gson.fromJson(response.bodyString(), QiNiuPutRet.class);
                return ResultVO.ofSuccess(ret);
            } else {
                return ResultVO.ofMessage(response.statusCode, response.getInfo());
            }

        } catch (QiniuException e) {
            Response response = e.response;
            try {
                return ResultVO.ofMessage(response.statusCode, response.bodyString());
            } catch (QiniuException e1) {
                e1.printStackTrace();
                return ResultVO.ofStatus(ResultEnum.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            return ResultVO.ofStatus(ResultEnum.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 房源信息编辑页
     *
     * @return
     */
    @GetMapping("/house/edit")
    public String houseEditPage(@RequestParam(value = "id") Long id, Model model) {

        if (id == null || id < 1) {
            return "404";
        }

        ServiceResult<HouseDTO> serviceResult = houseService.findCompleteOne(id);
        if (!serviceResult.isSuccess()) {
            return "404";
        }

        HouseDTO result = serviceResult.getResult();
        model.addAttribute("house", result);

        Map<SupportAddress.Level, SupportAddressDTO> addressMap = addressService.findCityAndRegion(result.getCityEnName(), result.getRegionEnName());
        model.addAttribute("city", addressMap.get(SupportAddress.Level.CITY));
        model.addAttribute("region", addressMap.get(SupportAddress.Level.REGION));

        HouseDetailDTO detailDTO = result.getHouseDetail();
        ServiceResult<SubwayDTO> subwayServiceResult = addressService.findSubway(detailDTO.getSubwayLineId());
        if (subwayServiceResult.isSuccess()) {
            model.addAttribute("subway", subwayServiceResult.getResult());
        }

        ServiceResult<SubwayStationDTO> subwayStationServiceResult = addressService.findSubwayStation(detailDTO.getSubwayStationId());
        if (subwayStationServiceResult.isSuccess()) {
            model.addAttribute("station", subwayStationServiceResult.getResult());
        }

        return "admin/house-edit";
    }

    /**
     * 编辑接口
     */
    @PostMapping("/house/edit")
    @ResponseBody
    public ResultVO saveHouse(@Valid @ModelAttribute("form-house-edit") HouseForm houseForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResultVO(HttpStatus.BAD_REQUEST.value(), bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
        }

        Map<SupportAddress.Level, SupportAddressDTO> addressMap = addressService.findCityAndRegion(houseForm.getCityEnName(), houseForm.getRegionEnName());

        if (addressMap.keySet().size() != 2) {
            return ResultVO.ofSuccess(ResultEnum.NOT_VALID_PARAM);
        }

        ServiceResult result = houseService.update(houseForm);
        if (result.isSuccess()) {
            return ResultVO.ofSuccess(null);
        }

        ResultVO response = ResultVO.ofStatus(ResultEnum.BAD_REQUEST);
        response.setMessage(result.getMessage());
        return response;
    }

    /**
     * 移除图片接口
     *
     * @param id
     * @return
     */
    @DeleteMapping("/house/photo")
    @ResponseBody
    public ResultVO removeHousePhoto(@RequestParam(value = "id") Long id) {
        ServiceResult result = this.houseService.removePhoto(id);

        if (result.isSuccess()) {
            return ResultVO.ofStatus(ResultEnum.SUCCESS);
        } else {
            return ResultVO.ofMessage(HttpStatus.BAD_REQUEST.value(), result.getMessage());
        }
    }

    /**
     * 修改封面接口
     *
     * @param coverId
     * @param targetId
     * @return
     */
    @PostMapping("/house/cover")
    @ResponseBody
    public ResultVO updateCover(@RequestParam(value = "cover_id") Long coverId,
                                @RequestParam(value = "target_id") Long targetId) {
        ServiceResult result = this.houseService.updateCover(coverId, targetId);

        if (result.isSuccess()) {
            return ResultVO.ofStatus(ResultEnum.SUCCESS);
        } else {
            return ResultVO.ofMessage(HttpStatus.BAD_REQUEST.value(), result.getMessage());
        }
    }

    /**
     * 增加标签接口
     *
     * @param houseId
     * @param tag
     * @return
     */
    @PostMapping("/house/tag")
    @ResponseBody
    public ResultVO addHouseTag(@RequestParam(value = "house_id") Long houseId,
                                @RequestParam(value = "tag") String tag) {
        if (houseId < 1 || Strings.isNullOrEmpty(tag)) {
            return ResultVO.ofStatus(ResultEnum.BAD_REQUEST);
        }

        ServiceResult result = this.houseService.addTag(houseId, tag);
        if (result.isSuccess()) {
            return ResultVO.ofStatus(ResultEnum.SUCCESS);
        } else {
            return ResultVO.ofMessage(HttpStatus.BAD_REQUEST.value(), result.getMessage());
        }
    }

    /**
     * 移除标签接口
     *
     * @param houseId
     * @param tag
     * @return
     */
    @DeleteMapping("admin/house/tag")
    @ResponseBody
    public ResultVO removeHouseTag(@RequestParam(value = "house_id") Long houseId,
                                   @RequestParam(value = "tag") String tag) {
        if (houseId < 1 || Strings.isNullOrEmpty(tag)) {
            return ResultVO.ofStatus(ResultEnum.BAD_REQUEST);
        }

        ServiceResult result = this.houseService.removeTag(houseId, tag);
        if (result.isSuccess()) {
            return ResultVO.ofStatus(ResultEnum.SUCCESS);
        } else {
            return ResultVO.ofMessage(HttpStatus.BAD_REQUEST.value(), result.getMessage());
        }
    }


}
