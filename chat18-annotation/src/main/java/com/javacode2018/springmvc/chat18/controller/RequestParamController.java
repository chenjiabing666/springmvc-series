package com.javacode2018.springmvc.chat18.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class RequestParamController {
    /**
     * {@link RequestParam}中指定name，用来取name的值对应的请求参数中的值
     *
     * @param name
     * @param age
     * @param pets
     * @return
     */
    @RequestMapping("/requestparam/test1")
    public Map<String, Object> test1(@RequestParam(value = "name", required = false, defaultValue = "ready") String name, //相当于request.getParameter("name")
                                     @RequestParam("age") int age, //Integer.parseInt(request.getParameter("age"))
                                     @RequestParam("interests") String[] interests, //request.getParameterValues("pets")
                                     @RequestParam("pets") List<String> pets //Arrays.asList(request.getParameterValues("pets"))
    ) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("name", name);
        result.put("age", age);
        result.put("interests", interests);
        result.put("pets", pets);
        return result;
    }

    /**
     * {@link RequestParam}不指定name，用于接收所有参数的值，
     * 参数类型为Map<String,String>,key为请求中的参数名称，value为值
     *
     * @param paramMap
     * @return
     */
    @RequestMapping("/requestparam/test2")
    public Map<String, String> test2(@RequestParam Map<String, String> paramMap) {
        return paramMap;
    }

    /**
     * {@link RequestParam}不指定name，用于接收所有参数的值，
     * 参数类型为MultiValueMap<String, String>：key为请求中的参数名称，value为值的集合List<String>
     *
     * @param paramMap
     * @return
     */
    @RequestMapping("/requestparam/test3")
    public MultiValueMap<String, String> test3(@RequestParam MultiValueMap<String, String> paramMap) {
        return paramMap;
    }
}
