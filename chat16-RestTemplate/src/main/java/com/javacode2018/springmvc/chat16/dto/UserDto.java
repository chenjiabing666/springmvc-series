package com.javacode2018.springmvc.chat16.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
public class UserDto {
    //姓名
    private String name;
    //头像
    private MultipartFile headImg;
    //多张证件照
    private List<MultipartFile> idImgList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getHeadImg() {
        return headImg;
    }

    public void setHeadImg(MultipartFile headImg) {
        this.headImg = headImg;
    }

    public List<MultipartFile> getIdImgList() {
        return idImgList;
    }

    public void setIdImgList(List<MultipartFile> idImgList) {
        this.idImgList = idImgList;
    }
}
