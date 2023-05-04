package com.javacode2018.springmvc.chat11.handle;

import com.javacode2018.springmvc.chat11.base.BusException;
import com.javacode2018.springmvc.chat11.base.ResultDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */

/**
 * 全局异常处理
 */
@RestControllerAdvice // @1
public class GlobalExceptionHandle {
    /**
     * 统一处理业务异常
     *
     * @param e
     * @param <T>
     * @return
     */
    @ExceptionHandler(BusException.class)
    public <T> ResultDto<T> doBusException(BusException e) {
        //1、记录错误日志
        //2、返回结果
        return ResultDto.error(e.getCode(), e.getMessage(), (T) e.getData());
    }

    /**
     * 处理其他异常
     *
     * @param e
     * @param <T>
     * @return
     */
    @ExceptionHandler
    public <T> ResultDto<T> doException(Exception e) {
        //1、记录错误日志
        //2、返回结果
        return ResultDto.error("系统异常，请联系管理员，错误详情：" + e.getMessage());
    }
}
