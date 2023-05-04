package com.javacode2018.springmvcseries.chat01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    /**
     * @RequestMapping：用来表示url和方法的映射
     * value属性用来指定一个url列表，springmvc会将这些指定的url请求转发给当前方法处理
     * @return
     */
    @RequestMapping("/hello.do")
    public ModelAndView hello(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/hello.jsp");
        //稍后将这个信息显示在hello.jsp中，modelAndView.addObject相当于request.setAttribute(name,value)
        modelAndView.addObject("msg","这是第一个springboot程序!");
        return modelAndView;
    }
}
