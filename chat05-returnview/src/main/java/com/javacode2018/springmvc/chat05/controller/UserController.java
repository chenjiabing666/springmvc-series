package com.javacode2018.springmvc.chat05.controller;

import com.javacode2018.springmvc.chat05.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@Controller
public class UserController {
    /**
     * 用户列表(用户id->用户信息)
     */
    Map<Long, UserDto> userDtoMap = new ConcurrentHashMap<>();

    {
        userDtoMap.put(1L, new UserDto(1L, "路人", 30));
        userDtoMap.put(2L, new UserDto(2L, "张三", 20));
        userDtoMap.put(3L, new UserDto(3L, "李四", 18));
    }

    /**
     * 用户列表
     *
     * @return
     */
    @RequestMapping("/user/list.do")
    public ModelAndView list() {
        //1.创建ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //2.将所有用户信息放到Model中
        modelAndView.addObject("userList", userDtoMap.values());
        //3.设置显示的页面
        modelAndView.setViewName("user/list");
        //4.返回ModelAndView
        return modelAndView;
    }

    /**
     * 跳转到新增页面
     *
     * @return
     */
    @RequestMapping("/user/add.do")
    public String add() {
        //直接返回视图的名称（页面的路径）
        return "user/add";
    }

    /**
     * 跳转到修改用户页面
     *
     * @return
     */
    @RequestMapping("/user/modify/{userId}.do")
    public ModelAndView modify(@PathVariable("userId") Long userId) {
        //1.创建ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //2.根据用户id获取用户信息
        UserDto userDto = this.userDtoMap.get(userId);
        //3.将用户信息放到Model中
        modelAndView.addObject("user", userDto);
        //4.设置显示的页面
        modelAndView.setViewName("user/modify");
        //5.返回ModelAndView
        return modelAndView;
    }

    /**
     * 保存用户信息
     *
     * @param userDto 用户信息
     * @return
     */
    @RequestMapping("/user/save.do")
    public ModelAndView save(UserDto userDto) {
        //1.修改用户信息
        this.userDtoMap.put(userDto.getId(), userDto);
        //2.调用list方法跳转到用户列表页面
        return this.list();
    }

    /**
     * 删除用户信息，删除成功之后重定向到用户列表页
     *
     * @param userId 用户id
     * @return
     */
    @GetMapping("/user/del/{userId}.do")
    public String del(@PathVariable("userId") Long userId, HttpServletRequest request) {
        //删除用户信息
        this.userDtoMap.remove(userId);
        //重定向到用户列表页面，此时浏览器地址会发生变化，变为http://localhost:8080/chat05/user/list.do
        return "redirect:/user/list.do";
    }

    /**
     * 删除用户信息，删除成功之后重定向到用户列表页，重定向的url中的带有参数
     *
     * @param userId 用户id
     * @return
     */
    @GetMapping("/user/del1/{userId}.do")
    public ModelAndView del1(@PathVariable("userId") Long userId) {
        //删除用户记录
        this.userDtoMap.remove(userId);

        /**
         * 重定向到用户列表页面，此时浏览器地址会发生变化，
         * 变为http://localhost:8080/chat05/user/list.do?p1=v1&p2=v2
         */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("p1", "v1");
        modelAndView.addObject("p2", "v2");
        modelAndView.setViewName("redirect:/user/list.do");
        return modelAndView;
    }

}
