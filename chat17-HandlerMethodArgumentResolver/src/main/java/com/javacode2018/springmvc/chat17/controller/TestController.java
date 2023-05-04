package com.javacode2018.springmvc.chat17.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@Controller
public class TestController {

    @RequestMapping("/test1")
    @ResponseBody
    public Map<String, Object> test1(@RequestParam("name") String name,
                                     @RequestParam("age") int age,
                                     @RequestParam("p1") String[] p1Map,
                                     @RequestParam Map<String, String> requestParams1,
                                     @RequestParam MultiValueMap requestParams2) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("name", name);
        result.put("age", age);
        result.put("p1Map", p1Map);
        result.put("requestParams1", requestParams1);
        result.put("requestParams2", requestParams2);
        return result;
    }

}
