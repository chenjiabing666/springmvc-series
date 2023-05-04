package com.javacode2018.springmvc.chat18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@Controller
public class RequestAttributeController {

    @RequestMapping("/requestattribute/test1")
    public String test1(HttpServletRequest request) {
        request.setAttribute("site",
                "<a href='http://www.java-family.cn'>路人博客，包含了所有系列文章，阅读更方便</a>");
        return "forward:/requestattribute/test2";
    }

    @RequestMapping(value = "/requestattribute/test2", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String test2(@RequestAttribute("site") String site) {
        return site;
    }
}
