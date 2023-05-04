package com.javacode2018.springmvc.chat10.controller;

import com.javacode2018.springmvc.chat10.exception.NameException;
import com.javacode2018.springmvc.chat10.exception.PassException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@Controller
public class UserController {

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("name") String name,
                              @RequestParam("pass") Integer pass) throws Exception {
        //用户名必须为路人
        if (!"路人".equals(name)) {
            throw new NameException("用户名有误!");
        }
        //密码必须为666
        if (!Integer.valueOf(666).equals(pass)) {
            throw new PassException("密码有误!");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
