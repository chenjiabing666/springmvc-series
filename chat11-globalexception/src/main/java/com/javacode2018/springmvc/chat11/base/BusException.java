package com.javacode2018.springmvc.chat11.base;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */

/**
 * 业务异常
 */
public class BusException extends RuntimeException {
    //异常错误码
    private String code;
    //错误扩展信息
    private Object data;

    public BusException(String msg) {
        this(null, msg);
    }

    public BusException(String code, String msg) {
        this(code, msg, null);
    }

    public BusException(String code, String msg, Object data) {
        super(msg);
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static void throwBusException(String msg) {
        throwBusException(null, msg);
    }

    public static void throwBusException(String code, String msg) {
        throwBusException(code, msg, null);
    }

    public static void throwBusException(String code, String msg, Object data) {
        throw new BusException(code, msg, data);
    }
}
