package com.wangguangwu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * preHandler 方法是顺序执行的，即和定义的顺序是一致的
 * 而拦截器中的其他 2 个方法 postHandler、afterCompletion 是逆序执行的，和 pewHandler 的顺序相反
 *
 * @author wangguangwu
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login() {
        return "login view";
    }

    @RequestMapping("/add")
    public String add() {
        return "add view";
    }

    @RequestMapping("/del")
    public String modify() {
        return "modify view";
    }

    @RequestMapping("/list")
    public String list() {
        return "list view";
    }

}
