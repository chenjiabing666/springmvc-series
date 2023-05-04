package com.javacode2018.springmvc.chat11.controller;

import com.javacode2018.springmvc.chat11.base.BusException;
import com.javacode2018.springmvc.chat11.base.ResultDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取用户id
     *
     * @param code
     * @return
     */
    @RequestMapping("/getUserName")
    public ResultDto<String> getUserName(@RequestParam("code") Integer code) {
        if (!Integer.valueOf(6666).equals(code)) {
            //验证码有误的时候，返回4001错误码
            BusException.throwBusException("4001", "验证码有误!");
        }
        return ResultDto.success("路人");
    }

    /**
     * 获取用户id
     *
     * @param code
     * @return
     */
    @RequestMapping("/getUserId")
    public ResultDto<String> getUserId(@RequestParam("code") Integer code) {
        if (!Integer.valueOf(6666).equals(code)) {
            BusException.throwBusException("4001", "验证码有误!");
        }
        return ResultDto.success("8888");
    }

}
