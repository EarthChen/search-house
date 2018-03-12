package com.earthchen.spring.boot.searchhouse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: EarthChen
 * @date: 2018/03/12
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
