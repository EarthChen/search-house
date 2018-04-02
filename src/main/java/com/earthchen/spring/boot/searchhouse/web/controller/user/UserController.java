package com.earthchen.spring.boot.searchhouse.web.controller.user;

import com.earthchen.spring.boot.searchhouse.enums.HouseSubscribeStatusEnum;
import com.earthchen.spring.boot.searchhouse.enums.ResultEnum;
import com.earthchen.spring.boot.searchhouse.service.ServiceMultiResult;
import com.earthchen.spring.boot.searchhouse.service.ServiceResult;
import com.earthchen.spring.boot.searchhouse.service.house.IHouseService;
import com.earthchen.spring.boot.searchhouse.service.user.IUserService;
import com.earthchen.spring.boot.searchhouse.util.LoginUserUtil;
import com.earthchen.spring.boot.searchhouse.web.dto.HouseDTO;
import com.earthchen.spring.boot.searchhouse.web.dto.HouseSubscribeDTO;
import com.earthchen.spring.boot.searchhouse.web.vo.ResultVO;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 用户控制器
 *
 * @author: EarthChen
 * @date: 2018/03/13
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IHouseService houseService;

    @GetMapping("/user/login")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/user/center")
    public String centerPage() {
        return "user/center";
    }

    /**
     * 修改用户个人信息
     *
     * @param profile
     * @param value
     * @return
     */
    @PostMapping("/api/user/info")
    @ResponseBody
    public ResultVO updateUserInfo(@RequestParam("/profile") String profile,
                                   @RequestParam("/value") String value) {
        if (value.isEmpty()) {
            return ResultVO.ofStatus(ResultEnum.BAD_REQUEST);
        }

        if ("email".equals(profile) && !LoginUserUtil.checkEmail(value)) {
            return ResultVO.ofMessage(HttpStatus.SC_BAD_REQUEST, "不支持的邮箱格式");
        }

        ServiceResult result = userService.modifyUserProfile(profile, value);
        if (result.isSuccess()) {
            return ResultVO.ofSuccess("");
        } else {
            return ResultVO.ofMessage(HttpStatus.SC_BAD_REQUEST, result.getMessage());
        }
    }


    @PostMapping("/api/user/house/subscribe")
    @ResponseBody
    public ResultVO subscribeHouse(@RequestParam("/house_id") Long houseId) {
        ServiceResult result = houseService.addSubscribeOrder(houseId);
        if (result.isSuccess()) {
            return ResultVO.ofSuccess("");
        } else {
            return ResultVO.ofMessage(HttpStatus.SC_BAD_REQUEST, result.getMessage());
        }
    }

    @GetMapping("/api/user/house/subscribe/list")
    @ResponseBody
    public ResultVO subscribeList(
            @RequestParam(name = "start", defaultValue = "0") int start,
            @RequestParam(name = "size", defaultValue = "3") int size,
            @RequestParam(name = "status") int status) {

        ServiceMultiResult<Pair<HouseDTO, HouseSubscribeDTO>> result = houseService.querySubscribeList(HouseSubscribeStatusEnum.of(status), start, size);

        if (result.getResultSize() == 0) {
            return ResultVO.ofSuccess(result.getResult());
        }

        ResultVO response = ResultVO.ofSuccess(result.getResult());
        response.setMore(result.getTotal() > (start + size));
        return response;
    }

    @PostMapping("/api/user/house/subscribe/date")
    @ResponseBody
    public ResultVO subscribeDate(
            @RequestParam("houseId") Long houseId,
            @RequestParam("orderTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date orderTime,
            @RequestParam(name = "desc", required = false) String desc,
            @RequestParam("telephone") String telephone) {
        if (orderTime == null) {
            return ResultVO.ofMessage(HttpStatus.SC_BAD_REQUEST, "请选择预约时间");
        }

        if (!LoginUserUtil.checkTelephone(telephone)) {
            return ResultVO.ofMessage(HttpStatus.SC_BAD_REQUEST, "手机格式不正确");
        }

        ServiceResult serviceResult = houseService.subscribe(houseId, orderTime, telephone, desc);
        if (serviceResult.isSuccess()) {
            return ResultVO.ofStatus(ResultEnum.SUCCESS);
        } else {
            return ResultVO.ofMessage(HttpStatus.SC_BAD_REQUEST, serviceResult.getMessage());
        }
    }

    @DeleteMapping("/api/user/house/subscribe")
    @ResponseBody
    public ResultVO cancelSubscribe(@RequestParam("houseId") Long houseId) {
        ServiceResult serviceResult = houseService.cancelSubscribe(houseId);
        if (serviceResult.isSuccess()) {
            return ResultVO.ofStatus(ResultEnum.SUCCESS);
        } else {
            return ResultVO.ofMessage(HttpStatus.SC_BAD_REQUEST, serviceResult.getMessage());
        }
    }
}
