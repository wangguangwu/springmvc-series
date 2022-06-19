package com.wangguangwu.dto;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author wangguangwu
 */
@Data
public class WorkInfoDto {

    private Integer workYears;

    private String workAddress;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
