package com.javacode2018.springmvc.chat18.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@Controller
public class SessionAttributeController {

    @RequestMapping(value = "/sessionattribute/test1", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String test1(HttpSession session) {
        //向session中放入数据
        session.setAttribute("site", null);
        //重定向
        return "session中放入了site信息!";
    }

    @RequestMapping(value = "/sessionattribute/test2", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String test2(@SessionAttribute("site") String site) {
        return site;
    }


    @RequestMapping(value = "m3", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public FileSystemResource m3() {
        return new FileSystemResource("E:\\idea\\springmvc-series\\chat18-annotation\\src\\main\\java\\com\\javacode2018\\springmvc\\chat18\\controller\\SessionAttributeController.java");
    }

}
