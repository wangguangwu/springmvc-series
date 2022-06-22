package com.wangguangwu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangguangwu
 */
@Controller
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        return "/WEB-INF/view/demo.jsp";
    }

}
