package com.javacode2018.springmvc.chat04.controller;

import com.javacode2018.springmvc.chat04.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@Controller
public class UploadController {

    /**
     * 单文件上传
     * 1、MultipartFile用来接收表单中上传的文件
     * 2、每个MultipartFile对应表单中的一个元素
     * 3、@RequestParam("f1")用来自动接受表单中的哪个元素？value用来指定表单元素的名称
     *
     * @param f1
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload1.do")
    public ModelAndView upload1(@RequestParam("file1") MultipartFile f1) throws IOException {
        //获取文件名称
        String originalFilename = f1.getOriginalFilename();
        String destFilePath = String.format("E:\\idea\\springmvc-series\\chat04-uploadfile\\src\\main\\webapp\\upfile\\%s", originalFilename);
        File destFile = new File(destFilePath);
        //调用transferTo将上传的文件保存到指定的地址
        f1.transferTo(destFile);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", destFile.getAbsolutePath());
        return modelAndView;
    }

    /**
     * 多文件上传
     * 1、方法中指定多个MultipartFile，每个MultipartFile对应一个上传的文件
     * 2、@RequestParam("file1") 用来指定具体接受上传的表单中哪个元素的名称
     *
     * @param f1
     * @param f2
     * @return
     */
    @RequestMapping("/upload2.do")
    public ModelAndView upload2(@RequestParam("file1") MultipartFile f1,
                                @RequestParam("file2") MultipartFile f2) {
        System.out.println("f1：" + f1);
        System.out.println("f2：" + f2);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", null);
        return modelAndView;
    }

    /**
     * 使用MultipartHttpServletRequest处理多文件上传
     * 上传文件的http请求会被转换为MultipartHttpServletRequest类型
     * MultipartHttpServletRequest中提供了很多很多方法用来获取请求中的参数
     *
     * @param request
     * @return
     */
    @RequestMapping("/upload3.do")
    public ModelAndView upload3(MultipartHttpServletRequest request) {
        //1.获取表单中非文件数据
        System.out.println("---------获取表单中非文件数据---------");
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((name, values) -> {
            System.out.println(String.format("%s:%s", name, Arrays.asList(values)));
        });
        //2、获取表单中文件数据
        System.out.println("---------获取表单中文件数据---------");
        MultiValueMap<String, MultipartFile> multiFileMap = request.getMultiFileMap();
        //2、遍历表单中元素信息
        multiFileMap.forEach((name, files) -> {
            System.out.println(String.format("%s:%s", name, files));
        });

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", "上传成功");
        return modelAndView;
    }

    @RequestMapping("/upload4.do")
    public ModelAndView upload4(UserDto userDto) {
        System.out.println("姓名：" + userDto.getName());
        System.out.println("年龄：" + userDto.getAge());
        System.out.println("头像文件：" + userDto.getHeadImg());
        System.out.println("多张身份证文件：" + Arrays.asList(userDto.getIdCardImg()));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", "上传成功");
        return modelAndView;
    }


}
