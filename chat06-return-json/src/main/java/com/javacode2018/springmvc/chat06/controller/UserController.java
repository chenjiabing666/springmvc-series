package com.javacode2018.springmvc.chat06.controller;

import com.javacode2018.springmvc.chat06.dto.ResultDto;
import com.javacode2018.springmvc.chat06.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@RestController
public class UserController {

    Map<Long, UserDto> userDtoMap = new ConcurrentHashMap<>();

    {
        userDtoMap.put(1L, new UserDto(1L, "路人", 30));
        userDtoMap.put(2L, new UserDto(2L, "张三", 20));
        userDtoMap.put(3L, new UserDto(3L, "李四", 18));
    }

    @GetMapping("/user/list.do")
    public ResultDto<Collection<UserDto>> list() {
        return ResultDto.success(this.userDtoMap.values());
    }


    @GetMapping("/user/{id}.do")
    public ResultDto<UserDto> user(@PathVariable("id") Long id) {
        return ResultDto.success(this.userDtoMap.get(id));
    }

}
