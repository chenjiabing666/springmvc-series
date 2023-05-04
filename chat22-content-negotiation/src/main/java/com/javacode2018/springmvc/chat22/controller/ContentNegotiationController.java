package com.javacode2018.springmvc.chat22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@Controller
public class ContentNegotiationController {

    @RequestMapping(value = "/cn/test1")
    @ResponseBody
    public List<String> test1() {
        List<String> result = Arrays.asList(
                "刘德华",
                "张学友",
                "郭富城",
                "黎明");
        return result;
    }

    @RequestMapping(value = "/cn/produces", produces = {"application/json"})
    @ResponseBody
    public List<String> testProduces() {
        List<String> result = Arrays.asList(
                "刘德华",
                "张学友",
                "郭富城",
                "黎明");
        return result;
    }

    @RequestMapping(value = "/cn/contenttype")
    public void testContentType(HttpServletResponse response) throws IOException {
        //指定了响应的结果的类型
        response.setHeader("Content-Type", "application/xml");
        response.getWriter().write(
                "<List>" +
                        "<item>刘德华</item>" +
                        "<item>张学友</item>" +
                        "<item>郭富城</item>" +
                        "<item>黎明</item>" +
                        "</List>");
        response.getWriter().flush();
    }

    @RequestMapping(value = "/cn/auto")
    @ResponseBody
    public List<String> testAuto(HttpServletResponse response) throws IOException {
        List<String> result = Arrays.asList(
                "刘德华",
                "张学友",
                "郭富城",
                "黎明");
        return result;
    }

}
