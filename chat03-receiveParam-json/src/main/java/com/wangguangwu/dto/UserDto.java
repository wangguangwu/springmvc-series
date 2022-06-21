package com.wangguangwu.dto;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wangguangwu
 */
@Getter
@Setter
public class UserDto {

    private String name;

    private Integer age;

    private String address;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
