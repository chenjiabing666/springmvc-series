package com.javacode2018.springmvc.chat09.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
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
