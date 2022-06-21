package com.wangguangwu.controller;

import com.wangguangwu.dto.ResultDto;
import com.wangguangwu.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 使用 @RestController 相当于同时使用 @Controller 和 @ResponseBody
 * controller 内部所有的方法都以 json 格式
 *
 * @author wangguangwu
 */
@RequestMapping("hello")
@RestController
public class UserController {

    Map<Long, UserDto> userDtoMap = new ConcurrentHashMap<>();

    public UserController() {
        userDtoMap.put(1L, new UserDto(1L, "张三", 18));
        userDtoMap.put(2L, new UserDto(2L, "李四", 20));
        userDtoMap.put(3L, new UserDto(3L, "王五", 22));
    }

    @GetMapping("/list")
    public Collection<UserDto> list() {
        return this.userDtoMap.values();
    }

    @GetMapping("/get/{id}")
    public ResultDto<UserDto> get(@PathVariable("id") Long id) {
        return ResultDto.success(this.userDtoMap.get(id));
    }

}
