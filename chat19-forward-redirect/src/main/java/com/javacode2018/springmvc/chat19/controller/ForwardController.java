package com.javacode2018.springmvc.chat19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@Controller
public class ForwardController {
    @RequestMapping("/forward/test1")
    public String test1() {
        return "forward:/forward/test1";
    }

    @RequestMapping(value = "/forward/test1", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String test2() {
        return "请求被转发到test2啦。";
    }
}
