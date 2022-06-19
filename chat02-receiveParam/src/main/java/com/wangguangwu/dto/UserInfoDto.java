package com.wangguangwu.dto;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author wangguangwu
 */
@Data
public class UserInfoDto {

    private String name;

    private Integer age;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
