package com.wangguangwu.controller;

import com.wangguangwu.dto.UserDto;
import com.wangguangwu.dto.UserInfoDto;
import com.wangguangwu.dto.WorkInfoDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author wangguangwu
 */
@SuppressWarnings("unused")
@Controller
@RequestMapping("/receiveParam")
public class ReceiveParamController {

    private static final String RESULT = "/WEB-INF/view/result.jsp";

    private static final String STRING_FORMAT = "name:%s,age:%s";

    /**
     * 如果方法内部需要用到HttpServletRequest、HttpServletResponse、HttpSession
     * 只需要在形参中定义这些类型即可，需要哪个就定义哪个
     * springmvc 在调用这个方法的时候，会自动将这些对象传入
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param session  HttpSession
     * @return ModelAndView
     */
    @RequestMapping("/test1.do")
    public ModelAndView test1(HttpServletRequest request,
                              HttpServletResponse response,
                              HttpSession session) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String msg = String.format(STRING_FORMAT, name, age);
        return getModelAndView(msg);
    }

    /**
     * springmvc 在调用此方法之前，会根据方法参数名称，从请求中获取参数的值，将其传入
     * <p>
     * 过程：
     * 1. 将 request.getParameter("name") 传递给方法的第 1 个参数 name
     * 2. 将 Integer.valueOf(request.getParameter("age")) 传递给方法的第 2 个参数 age
     *
     * @param name name
     * @param age  age
     * @return ModelAndView
     */
    @RequestMapping("/test2.do")
    public ModelAndView test2(String name, Integer age) {
        String msg = String.format(STRING_FORMAT, name, age);
        return getModelAndView(msg);
    }

    /**
     * 如果方法的参数名称和表单中的参数名称不一致的时候，可以通过 @RequestParam 注解的 value 属性来指定表单中参数的名称
     * <p>
     * 比如：@RequestParam("wName") String name 接收 request.getParameter("wName") 的值
     * 1、将 request.getParameter("wName") 传递给方法的第 1 个参数 name
     * 2、将 Integer.valueOf(request.getParameter("wAge")) 传递给方法的第 2 个参数 age
     *
     * @param name name
     * @param age  age
     * @return ModelAndView
     */
    @RequestMapping("/test3.do")
    public ModelAndView test3(@RequestParam("wName") String name,
                              @RequestParam("wAge") Integer age) {
        String msg = String.format(STRING_FORMAT, name, age);
        return getModelAndView(msg);
    }

    @RequestMapping("/test4.do")
    public ModelAndView test4(UserInfoDto userInfoDto) {
        String msg = String.format("userDto：%s", userInfoDto);
        return getModelAndView(msg);
    }

    @RequestMapping("/test5.do")
    public ModelAndView test5(UserInfoDto userInfoDto, WorkInfoDto workInfoDto) {
        String msg = String.format("userInfoDto：[%s], workInfoDto：[%s]", userInfoDto, workInfoDto);
        return getModelAndView(msg);
    }

    @RequestMapping("/test6.do")
    public ModelAndView test6(UserDto userDto) {
        String msg = String.format("userDto:[%s]", userDto);
        return getModelAndView(msg);
    }

    @RequestMapping("/{v1}/{v2}.do")
    public ModelAndView test7(@PathVariable("v1") String p1, @PathVariable("v2") String p2) {
        String msg = String.format("p1：[%s]，p2：[%s]", p1, p2);
        return getModelAndView(msg);
    }

    //==========================私有方法==============================

    private ModelAndView getModelAndView(String msg) {
        System.out.println(msg);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(RESULT);
        modelAndView.addObject("msg", msg);
        return modelAndView;
    }

}
