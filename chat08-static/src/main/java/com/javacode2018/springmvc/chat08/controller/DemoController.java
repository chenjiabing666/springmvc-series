package com.javacode2018.springmvc.chat08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@Controller
public class DemoController {

    @RequestMapping("/demo.do")
    public String demo() {
        return "/WEB-INF/view/demo.jsp";
    }
}
