package com.wangguangwu.controller;

import com.wangguangwu.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 上传文件
 *
 * @author wangguangwu
 */
@RequestMapping("/hello")
@Controller
public class UploadController {

    /**
     * 单文件上传
     * <p>
     * 1.MultipartFile 用来接收表单中上传的文件
     * 2.每个 MultipartFile 对应表单中的一个元素
     * 3.@RequestParam("f1")用来自动接受表单中的哪个元素，value用来指定表单元素的名称
     */
    @PostMapping("/upload1")
    public ModelAndView upload1(@RequestParam("file") MultipartFile file) throws IOException {
        // 获取文件名称
        String originalFileName = file.getOriginalFilename();
        String destFilePath = String.format("/Users/wangguangwu/Desktop/excel/%s", originalFileName);
        File destFile = new File(destFilePath);
        // 调用 transferTo 将上传的文件保存到指定的位置
        file.transferTo(destFile);

        return getModelAndView(destFile.getAbsolutePath());
    }


    /**
     * 多文件上传
     * <p>
     * 1.方法中指定多个 MultipartFile，每个 MultipartFile 对应一个上传的文件
     * 2.@RequestParam("file1") 用来指定具体接受上传的表单中哪个元素的名称
     */
    @PostMapping("/upload2")
    public ModelAndView upload2(@RequestParam("file1") MultipartFile file1,
                                @RequestParam("file2") MultipartFile file2) {
        String msg = file1 + ";\r\n" + file2;
        return getModelAndView(msg);
    }

    /**
     * 使用 MultipartHttpServletRequest 处理多文件上传
     * 上传文件的 http 请求会被转换为 MultipartHttpServletRequest 类型
     * MultipartHttpServletRequest 中提供了很多方法来获取请求中的参数
     */
    @PostMapping("/upload3")
    public ModelAndView upload3(MultipartHttpServletRequest request) {
        // 1. 获取表单中非文件数据
        System.out.println("---------获取表单中非文件数据---------");
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((name, values) -> System.out.printf("%s:%s", name, Arrays.toString(values)));
        // 2. 获取表单中文件数据
        System.out.println("---------获取表单中文件数据---------");
        MultiValueMap<String, MultipartFile> multiFileMap = request.getMultiFileMap();
        multiFileMap.forEach((name, file) -> System.out.printf("%s:%s", name, file));

        return getModelAndView("上传成功");
    }

    @PostMapping("/upload4")
    public ModelAndView upload4(UserDto userDto) {
        System.out.println("姓名：" + userDto.getName());
        System.out.println("年龄：" + userDto.getAge());
        System.out.println("头像文件：" + userDto.getHeadImg());
        System.out.println("多张身份证文件：" + List.of(userDto.getIdCardImg()));

        return getModelAndView("上传成功");
    }


    //=======================私有方法=======================

    private ModelAndView getModelAndView(String message) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", message);
        return modelAndView;
    }

}
