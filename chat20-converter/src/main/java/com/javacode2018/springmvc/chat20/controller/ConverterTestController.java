package com.javacode2018.springmvc.chat20.controller;

import com.javacode2018.springmvc.chat20.dto.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@RestController
public class ConverterTestController {

    @RequestMapping("/convert/test1")
    public UserDto test1(@RequestParam("user") UserDto user) {
        System.out.println("name：" + user.getName());
        System.out.println("age：" + user.getAge());
        return user;
    }

}
