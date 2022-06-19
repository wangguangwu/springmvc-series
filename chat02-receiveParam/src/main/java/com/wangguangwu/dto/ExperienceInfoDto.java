package com.wangguangwu.dto;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author wangguangwu
 */
@Data
public class ExperienceInfoDto {

    private String company;

    private String position;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
