package com.code2018.springmvc.chat16.dto;

/**
 * 公众号：码猿技术专栏，专注于干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 * git地址：https://gitee.com/code2018
 */
public class BookDto {
    private Integer id;
    private String name;

    public BookDto() {
    }

    public BookDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
