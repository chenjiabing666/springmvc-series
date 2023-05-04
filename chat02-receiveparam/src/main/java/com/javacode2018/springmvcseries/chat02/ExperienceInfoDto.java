package com.javacode2018.springmvcseries.chat02;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */

/**
 * 工作经验
 */
public class ExperienceInfoDto {
    //公司
    private String company;
    //职位
    private String position;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ExperienceInfoDto{" +
                "company='" + company + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
