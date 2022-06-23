package com.wangguangwu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangguangwu
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/testError")
    public String testError() {
        System.out.println(10 / 0);
        return "success";
    }

}
