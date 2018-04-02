package com.earthchen.spring.boot.searchhouse.web.controller;

import com.earthchen.spring.boot.searchhouse.service.ISmsService;
import com.earthchen.spring.boot.searchhouse.service.ServiceResult;
import com.earthchen.spring.boot.searchhouse.util.LoginUserUtil;
import com.earthchen.spring.boot.searchhouse.web.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.transform.Result;

/**
 * @author: EarthChen
 * @date: 2018/03/12
 */
@Controller
public class HomeController {

    @Autowired
    private ISmsService smsService;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/404")
    public String notFoundPage() {
        return "404";
    }

    @GetMapping("/403")
    public String accessError() {
        return "403";
    }

    @GetMapping("/500")
    public String internalError() {
        return "500";
    }

    @GetMapping("/logout/page")
    public String logoutPage() {
        return "logout";
    }


    /**
     * 短信验证吗接口
     *
     * @param telephone
     * @return
     */
    @GetMapping("/sms/code")
    @ResponseBody
    public ResultVO smsCode(@RequestParam("telephone") String telephone) {
        if (!LoginUserUtil.checkTelephone(telephone)) {
            return ResultVO.ofMessage(HttpStatus.BAD_REQUEST.value(), "请输入正确的手机号");
        }
        ServiceResult<String> result = smsService.sendSms(telephone);
        if (result.isSuccess()) {
            return ResultVO.ofSuccess("");
        } else {
            return ResultVO.ofMessage(HttpStatus.BAD_REQUEST.value(), result.getMessage());
        }

    }
}
