package com.javacode2018.springmvc.chat07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.TimeUnit;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@Controller
public class AsyncController {

    @ResponseBody
    @RequestMapping("/async/m1.do")
    public String m1() throws InterruptedException {
        long st = System.currentTimeMillis();
        System.out.println("主线程：" + Thread.currentThread() + "," + st + ",开始");
        //休眠3秒，模拟耗时的业务操作
        TimeUnit.SECONDS.sleep(3);
        long et = System.currentTimeMillis();
        System.out.println("主线程：" + Thread.currentThread() + "," + st + ",结束,耗时(ms):" + (et - st));
        return "ok";
    }

    /**
     * 使用springmvc的异步功能，业务处理放在异步线程中执行
     *
     * @param timeout 异步处理超时时间
     * @return
     */
    @ResponseBody
    @RequestMapping("/async/m2/{timeout}.do")
    public DeferredResult<String> m2(@PathVariable("timeout") long timeout) {
        long st = System.currentTimeMillis();
        System.out.println("主线程：" + Thread.currentThread() + "," + st + ",开始");
        /**
         * 1、创建DeferredResult<返回值类型>(超时时间[毫秒],超时回调的代码)
         */
        DeferredResult<String> result = new DeferredResult<String>(timeout, () -> {
            System.out.println("超时了");
            return "timeout";
        });
        //2、异步处理业务，
        new Thread(() -> {
            //开启一个异步线程，在异步线程中进行业务处理操作
            try {
                TimeUnit.SECONDS.sleep(3);
                //3、调用DeferredResult的setResult方法，设置最终返回到客户端的结果，此方法调用以后，客户端将接收到返回值
                result.setResult("ok");
            } catch (InterruptedException e) {
                result.setResult("发生异常了:" + e.getMessage());
            }
        }).start();
        long et = System.currentTimeMillis();
        System.out.println("主线程：" + Thread.currentThread() + "," + st + ",结束,耗时(ms):" + (et - st));
        //3、将DefaultResult作为方法返回值
        return result;
    }
}
