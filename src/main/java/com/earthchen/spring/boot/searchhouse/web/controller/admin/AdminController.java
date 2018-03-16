package com.earthchen.spring.boot.searchhouse.web.controller.admin;

import com.earthchen.spring.boot.searchhouse.domain.SupportAddress;
import com.earthchen.spring.boot.searchhouse.enums.ResultEnum;
import com.earthchen.spring.boot.searchhouse.service.ServiceResult;
import com.earthchen.spring.boot.searchhouse.service.house.IAddressService;
import com.earthchen.spring.boot.searchhouse.service.house.IHouseService;
import com.earthchen.spring.boot.searchhouse.service.house.IQiNiuService;
import com.earthchen.spring.boot.searchhouse.web.dto.HouseDTO;
import com.earthchen.spring.boot.searchhouse.web.dto.QiNiuPutRet;
import com.earthchen.spring.boot.searchhouse.web.dto.SupportAddressDTO;
import com.earthchen.spring.boot.searchhouse.web.form.HouseForm;
import com.earthchen.spring.boot.searchhouse.web.vo.ResultVO;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
    public String addHousePage(){
        return "admin/house-add";
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
}
