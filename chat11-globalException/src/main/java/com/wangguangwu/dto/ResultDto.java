package com.wangguangwu.dto;



/**
 * @author wangguangwu
 */
@SuppressWarnings("unused")
public class ResultDto<T> {
    private Boolean success;

    private String code;

    private String msg;

    private T data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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

    public static <T> ResultDto<T> error(String msg) {
        return error(null,msg);
    }
    public static <T> ResultDto<T> error(String code,String msg) {
        return error(code,msg,null);
    }
    public static <T> ResultDto<T> error(String code, String msg, T data) {
        ResultDto<T> result = new ResultDto<>();
        result.setSuccess(Boolean.FALSE);
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
