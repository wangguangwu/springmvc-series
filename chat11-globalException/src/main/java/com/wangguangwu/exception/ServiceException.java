package com.wangguangwu.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangguangwu
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class ServiceException extends RuntimeException {

    private final String code;

    private final transient Object data;

    public ServiceException(String code, String msg) {
        this(code, msg, null);
    }

    public ServiceException(String code, String msg, Object data) {
        super(msg);
        this.code = code;
        this.data = data;
    }

    public static void throwServiceException(String msg) {
        throwServiceException(null, msg);
    }


    public static void throwServiceException(String code, String msg) {
        throwServiceException(code, msg, null);
    }

    public static void throwServiceException(String code, String msg, Object data) {
        throw new ServiceException(code, msg, data);
    }

}
