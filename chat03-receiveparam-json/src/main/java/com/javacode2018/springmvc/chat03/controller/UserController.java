package com.javacode2018.springmvc.chat03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@Controller
public class UserController {

    @PostMapping("/user/add.do")
    public ModelAndView add(@RequestBody UserDto user) {
        System.out.println("user:" + user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", user);
        return modelAndView;
    }

    @PostMapping("/m1.do")
    public void m1(@RequestBody String body) {
        System.out.println(body);
    }

    @PostMapping("/m2.do")
    public void m2(@RequestBody byte[] body) {
        System.out.println(new String(body));
    }

}
