package com.javacode2018.springmvc.chat18.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@RestController
public class CookieValueController {

    @RequestMapping("/cookievalue/test1")
    public Map<String, Object> test1(@CookieValue("name") String name,
                                     @CookieValue("age") int age) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("name", name);
        result.put("age", age);
        return result;
    }

    /**
     * @param nameCookie
     * @param ageCookie
     * @return
     */
    @RequestMapping("/cookievalue/test2")
    public Map<String, Object> test2(@CookieValue("name") Cookie nameCookie,
                                     @CookieValue("age") Cookie ageCookie) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("nameCookie", nameCookie);
        result.put("ageCookie", ageCookie);
        return result;
    }

}
