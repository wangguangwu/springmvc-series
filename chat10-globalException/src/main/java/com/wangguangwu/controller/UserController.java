package com.wangguangwu.controller;

import com.wangguangwu.exception.NameException;
import com.wangguangwu.exception.PasswordException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangguangwu
 */
@Controller
public class UserController {

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("name") String name,
                              @RequestParam("password") Integer password) throws Exception {
        if (!"wangguangwu".equals(name)) {
            throw new NameException("用户名有误");
        }
        if (!Integer.valueOf(666).equals(password)) {
            throw new PasswordException("密码有误!");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("name", name);
        return modelAndView;
    }

}
