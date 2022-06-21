package com.wangguangwu.controller;

import com.wangguangwu.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Servlet 响应页面的 2 种方式：
 * <p>
 * servlet 响应页面中有 2 种常见的方式，而 springmvc 中通常也是依靠这 2 种方式实现的。
 * <p>
 * 方式 1：转向
 * request.getRequestDispatcher(path).forward(request, response);
 * <p>
 * a. path 为转向的地址
 * b. 发生在服务器端，浏览器的地址栏不会发生变化
 * c. path 指定的页面，可以共享 request 请求中的数据
 * d. path 必须是服务器端的资源
 * <p>
 * 方向 2：重定向
 * response.setRedirect(location);
 * <p>
 * a. location 为重定向的地址
 * b. 重定向发生在客户端（浏览器端），所以会导致浏览器地址栏发生变化，变为 location 指定的地址
 * c. 重定向会导致浏览器重新向服务器端发生一次请求，请求地址为 location 指定的地址
 * d. location 可以为本服务器端的资源，也可以为外网可以访问的任意资源，比如：http://www.baidu.com
 *
 * @author wangguangwu
 */
@RequestMapping("user")
@Controller
public class UserController {

    Map<Long, UserDto> userDtoMap = new ConcurrentHashMap<>();

    public UserController() {
        userDtoMap.put(1L, new UserDto(1L, "路人", 30));
        userDtoMap.put(2L, new UserDto(2L, "张三", 20));
        userDtoMap.put(3L, new UserDto(3L, "李四", 18));
    }

    /**
     * 列表显示
     * <p>
     * ModelAndView：模型 & 视图
     * <p>
     * 将模板（视图）+ 数据（数据模型），经过组装之后输出到客户端
     * 两个关键数据：
     * 1. 视图
     * 2. 数据模型
     * <p>
     * springmvc 中使用 ModelAndView 来存放这两个信息：
     * 1. 通过 modelAndView.addObject 方法添加页面中用到的数据
     * 2. 通过 modelAndView.setViewName("视图名称") 来设置显示的页面
     */
    @GetMapping("/list")
    public ModelAndView list() {
        // 1. 创建 ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 2. 将所有用户信息放到 model 中
        modelAndView.addObject("userList", userDtoMap.values());
        // 3. 设置显示的页面
        String viewName = "list";
        modelAndView.setViewName(viewName);
        // 4. 返回 ModelAndView
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add() {
        // 直接返回视图的名称（页面的路径）
        return "add";
    }

    @RequestMapping("/modify/{userId}")
    public ModelAndView modify(@PathVariable("userId") Long userId) {
        // 1. 创建 ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 2. 根据用户 id 获取用户信息
        UserDto userDto = this.userDtoMap.get(userId);
        // 3. 将用户信息放到 Model 中
        modelAndView.addObject("user", userDto);
        // 4. 设置显示的页面
        modelAndView.setViewName("modify");
        // 5. 返回 ModelAndView
        return modelAndView;
    }

    @RequestMapping("/save")
    public ModelAndView save(UserDto userDto) {
        // 1. 修改用户信息
        this.userDtoMap.put(userDto.getId(), userDto);
        // 2. 调用 list 方法跳转到用户列表画面
        return this.list();
    }


    @GetMapping("/del/{userId}")
    public String del(@PathVariable("userId") Long userId, HttpServletRequest request) {
        System.out.println(request.getRequestURI());
        // 1. 删除用户信息
        this.userDtoMap.remove(userId);
        // 2. 重定向到用户列表页面，此时浏览器地址会发生变化，变为 http://localhost:8080/chat05/user/list
        return "redirect:/user/list";
    }

    /**
     * 删除用户信息，删除成功后重新定向到用户列表页，重定向中的 url 中带有参数
     *

     */
    @GetMapping("/del1/{userId}")
    public ModelAndView del1(@PathVariable("userId") Long userId) {
        // 1. 删除用户记录
        this.userDtoMap.remove(userId);
        // 2. 重定向到用户列表页面，此时浏览器地址会发生变化，变为 http://localhost:8080/chat05/user/list?p1=v1&p2=v2
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("p1", "v1");
        modelAndView.addObject("p2", "v2");
        modelAndView.setViewName("redirect:/user/list");
        return modelAndView;
    }

}
