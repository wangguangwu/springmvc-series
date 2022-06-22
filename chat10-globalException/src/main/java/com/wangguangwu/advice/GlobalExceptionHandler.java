package com.wangguangwu.advice;

import com.wangguangwu.exception.NameException;
import com.wangguangwu.exception.PasswordException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangguangwu
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 此方法用来处理 NameException 类型的异常，
     * 当 controller 抛出 NameException 异常的时候，此方法会被调用
     */
    @ExceptionHandler({NameException.class})
    public ModelAndView doNameException(Exception e) {
        System.out.println("-----doNameException-----");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("msg", "登录名有误!");
        modelAndView.addObject("e", e);
        return modelAndView;
    }

    /**
     * 此方法用来处理 AgeException 类型的异常，
     * 当 controller 抛出 NameException 异常的时候，此方法会被调用
     */
    @ExceptionHandler({PasswordException.class})
    public ModelAndView doPasswordException(Exception e) {
        System.out.println("-----doPassException-----");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("msg", "密码有误!");
        modelAndView.addObject("e", e);
        return modelAndView;
    }

    /**
     * 此方法用来处理任意异常（也就是上面2个方法不能够处理的异常都会被这个方法处理）
     */
    @ExceptionHandler
    public ModelAndView doException(Exception e) {
        System.out.println("-----doException-----");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("msg", "系统异常!");
        modelAndView.addObject("e", e);
        return modelAndView;
    }

}
