package com.wangguangwu.dto;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;

/**
 * @author wangguangwu
 */
@Data
public class UserDto {

    private UserInfoDto userInfo;

    private WorkInfoDto workInfo;

    private List<ExperienceInfoDto> experienceInfos;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
