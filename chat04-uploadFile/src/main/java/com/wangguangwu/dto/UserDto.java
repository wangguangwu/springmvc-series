package com.wangguangwu.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author wangguangwu
 */
@Data
public class UserDto {

    private String name;

    private Integer age;

    private MultipartFile headImg;

    private List<MultipartFile> idCardImg;

}
