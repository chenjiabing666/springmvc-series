package com.javacode2018.springmvc.chat12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 测试异常情况
     *
     * @return
     */
    @RequestMapping("/testError")
    public String testError() {
        System.out.println(10 / 0);
        return "success";
    }
}
