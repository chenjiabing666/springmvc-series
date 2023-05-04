package com.javacode2018.springmvc.chat18.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@RestController
public class RequestHeaderController {

    @RequestMapping("/requestheader/test1")
    public Map<String, Object> test1(@RequestHeader(value = "name", required = false, defaultValue = "ready") String name,
                                     @RequestHeader(value = "age") int age,
                                     @RequestHeader(value = "header1") List<String> header1) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("name", name);
        result.put("age", age);
        result.put("header1", header1);
        return result;
    }

    /**
     * {@link RequestHeader}不指定name，用于接收所有header的值，
     * 参数类型为Map<String,String>：key为头的名称，value为header的值
     *
     * @param headerMap
     * @return
     */
    @RequestMapping("/requestheader/test2")
    public Map<String, String> test2(@RequestHeader Map<String, String> headerMap) {
        return headerMap;
    }

    /**
     * {@link RequestHeader}不指定name，用于接收所有header的值，
     * 参数类型为MultiValueMap,相当于Map<String,List<String>>：key为头的名称，value为header的值列表
     *
     * @param headerMap
     * @return
     */
    @RequestMapping("/requestheader/test3")
    public Map<String, List<String>> test3(@RequestHeader MultiValueMap headerMap) {
        Map<String, List<String>> result = new LinkedHashMap<>(headerMap);
        return result;
    }


    /**
     * {@link RequestHeader}不指定name，用于接收所有header的值，
     * 参数类型为HttpHeaders，实现了MultiValueMap接口，HttpHeaders中提供了大量的获取头信息的各种方法，使用特别方便
     *
     * @param httpHeaders
     * @return
     */
    @RequestMapping("/requestheader/test4")
    public Map<String, List<String>> test4(@RequestHeader HttpHeaders httpHeaders) {
        Map<String, List<String>> result = new LinkedHashMap<>(httpHeaders);
        return result;
    }

}
