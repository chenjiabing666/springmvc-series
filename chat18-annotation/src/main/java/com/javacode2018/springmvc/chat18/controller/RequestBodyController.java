package com.javacode2018.springmvc.chat18.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;
/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@RestController
public class RequestBodyController {

    @RequestMapping("/requestbody/test1")
    public String test1(@RequestBody String body) {
        System.out.println("body:" + body);
        return "ok";
    }

    @RequestMapping("/requestbody/test2")
    public String test2(@RequestBody User user) {
        System.out.println("user:" + user);
        return "ok";
    }

    /**
     * 参数为如果为 org.springframework.core.io.Resource 类型，
     * 则只能为Resource的[ByteArrayResource,InputStreamResource]这2种子类型:
     *
     * @param body
     * @return
     * @throws IOException
     */
    @RequestMapping("/requestbody/test3")
    public String test3(@RequestBody InputStreamResource body) throws IOException {
        String content = IOUtils.toString(body.getInputStream(), "UTF-8");
        System.out.println("content:" + content);
        return "ok";
    }

/**
 * 使用字节数组接收
 *
 * @param bodyBytes
 * @return
 */
@RequestMapping("/requestbody/test4")
public String test4(@RequestBody byte[] bodyBytes) {
    System.out.println("body长度(bytes)：" + bodyBytes.length);
    System.out.println("body内容：" + new String(bodyBytes));
    return "ok";
}

@RequestMapping("/requestbody/test5")
public String test5(HttpEntity<User> httpEntity) {
    //header信息
    HttpHeaders headers = httpEntity.getHeaders();
    System.out.println("headers:" + headers);
    //body中的内容会自动转换为HttpEntity中泛型指定的类型
    User user = httpEntity.getBody();
    System.out.println("body:" + user);
    return "ok";
}

@RequestMapping("/requestbody/test6")
public String test6(RequestEntity<User> requestEntity) {
    //请求方式
    HttpMethod method = requestEntity.getMethod();
    System.out.println("method:" + method);
    //请求地址
    URI url = requestEntity.getUrl();
    System.out.println("url:" + url);
    //body的类型，即RequestEntity后面尖括号中的类型
    Type type = requestEntity.getType();
    System.out.println("body的类型，即RequestEntity后面尖括号中的类型:" + type);
    //header信息
    HttpHeaders headers = requestEntity.getHeaders();
    System.out.println("headers:" + headers);
    //body中的内容会自动转换为HttpEntity中泛型指定的类型
    User user = requestEntity.getBody();
    System.out.println("body:" + user);
    return "ok";
}

    public static class User {
        private String name;
        private Integer age;
        private List<String> skills;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public List<String> getSkills() {
            return skills;
        }

        public void setSkills(List<String> skills) {
            this.skills = skills;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", skills=" + skills +
                    '}';
        }
    }
}
