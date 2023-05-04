package com.javacode2018.springmvc.chat19.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@Controller
public class RedirectController {

    @RequestMapping("/redirect/test1")
    public String test1() {
        return "redirect:/redirect/test2";
    }

    @RequestMapping(value = "/redirect/test2", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String test2() {
        return "我是test2";
    }

    @RequestMapping("/redirect/test3")
    public String test3(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name", "路人");
        redirectAttributes.addAttribute("age", 30);
        return "redirect:/redirect/test4";
    }

    @RequestMapping(value = "/redirect/test4", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> test4(@RequestParam("name") String name, @RequestParam("age") int age) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("name", name);
        result.put("age", age);
        return result;
    }

    @RequestMapping("/redirect/test5")
    public String test5(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("name", "路人");
        redirectAttributes.addFlashAttribute("age", 30);
        return "redirect:/redirect/test6";
    }

    /**
     * 需要使用一个org.springframework.ui.Model或者org.springframework.ui.ModelMap类型的参数来接收传递过来的参数，
     * 方法内部调用model.getAttribute("参数名")可以获取传递过来的参数
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/redirect/test6", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> test6(Model model) {
        String name = (String) model.getAttribute("name");
        Integer age = (Integer) model.getAttribute("age");
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("name", name);
        result.put("age", age);
        return result;
    }
}
