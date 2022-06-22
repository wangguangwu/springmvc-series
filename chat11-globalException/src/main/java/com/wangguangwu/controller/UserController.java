package com.wangguangwu.controller;

import com.wangguangwu.dto.ResultDto;
import com.wangguangwu.exception.ServiceException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取用户id
     */
    @GetMapping("/getUserName")
    public ResultDto<String> getUserName(@RequestParam("code") Integer code) {
        if (!Integer.valueOf(6666).equals(code)) {
            //验证码有误的时候，返回4001错误码
            ServiceException.throwServiceException("4001", "验证码有误!");
        }
        return ResultDto.success("汪光武");
    }

    /**
     * 获取用户id
     */
    @GetMapping("/getUserId")
    public ResultDto<String> getUserId(@RequestParam("code") Integer code) {
        if (!Integer.valueOf(6666).equals(code)) {
            ServiceException.throwServiceException("4001", "验证码有误!");
        }
        return ResultDto.success("8888");
    }

}
