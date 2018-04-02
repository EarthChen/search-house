package com.earthchen.spring.boot.searchhouse.web.controller.user;

import com.earthchen.spring.boot.searchhouse.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/user/login")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/user/center")
    public String centerPage() {
        return "user/center";
    }
}
