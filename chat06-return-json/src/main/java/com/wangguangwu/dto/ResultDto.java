package com.wangguangwu.dto;

import lombok.Data;

/**
 * Restfull 接口统一返回值
 *
 * @author wangguangwu
 */
@Data
public class ResultDto<T> {

    private Boolean success;

    private String code;

    private String msg;

    private T data;

    public static <T> ResultDto<T> success(T data) {
        return success(data, "操作成功!");
    }

    public static <T> ResultDto<T> success(T data, String msg) {
        ResultDto<T> result = new ResultDto<>();
        result.setSuccess(Boolean.TRUE);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

}
