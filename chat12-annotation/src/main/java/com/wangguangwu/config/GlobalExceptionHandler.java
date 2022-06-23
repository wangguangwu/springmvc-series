package com.wangguangwu.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangguangwu
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ModelAndView doException(Exception e) {
        String errorJsp = "error";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(errorJsp);
        modelAndView.addObject("ex", e);
        return modelAndView;
    }

}
