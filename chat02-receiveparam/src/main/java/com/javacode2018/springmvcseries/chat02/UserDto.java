package com.javacode2018.springmvcseries.chat02;


import java.util.List;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */

/**
 * 用户信息
 */
public class UserDto {
    //个人基本信息
    private UserInfoDto userInfo;
    //工作信息
    private WorkInfoDto workInfo;
    //工作经验（0到n个）
    private List<ExperienceInfoDto> experienceInfos;

    public UserInfoDto getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoDto userInfo) {
        this.userInfo = userInfo;
    }

    public WorkInfoDto getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(WorkInfoDto workInfo) {
        this.workInfo = workInfo;
    }

    public List<ExperienceInfoDto> getExperienceInfos() {
        return experienceInfos;
    }

    public void setExperienceInfos(List<ExperienceInfoDto> experienceInfos) {
        this.experienceInfos = experienceInfos;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userInfo=" + userInfo +
                ", workInfo=" + workInfo +
                ", experienceInfos=" + experienceInfos +
                '}';
    }
}
