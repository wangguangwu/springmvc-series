package com.wangguangwu.controller;

import com.wangguangwu.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangguangwu
 */
@RequestMapping("hello")
@Controller
public class UserController {

    @PostMapping("/add.do")
    public ModelAndView add(@RequestBody UserDto user) {
        System.out.println("user:" + user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", user);
        return modelAndView;
    }

    @PostMapping("/m1.do")
    public String m1(@RequestBody String body) {
        System.out.println(body);
        return body;
    }

    @PostMapping("/m2.do")
    public String m2(@RequestBody byte[] body) {
        System.out.println(new String(body));
        return new String(body);
    }
}
