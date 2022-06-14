package com.wangguangwu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangguangwu
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public ModelAndView hello(HttpServletRequest request) {
        System.out.println("request:" + request);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/hello.jsp");
        // modelAndView.addObject 方法相当于 request.setAttribute 方法
        modelAndView.addObject("msg", "Hello wangguangwu");
        return modelAndView;
    }

}
