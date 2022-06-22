package com.wangguangwu.advice;

import com.wangguangwu.dto.ResultDto;
import com.wangguangwu.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wangguangwu
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 统一处理业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public <T> ResultDto<T> doBusException(ServiceException e) {
        //1、记录错误日志
        //2、返回结果
        return ResultDto.error(e.getMessage());
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler
    public <T> ResultDto<T> doException(Exception e) {
        //1、记录错误日志
        //2、返回结果
        return ResultDto.error("系统异常，请联系管理员，错误详情：" + e.getMessage());
    }
}