package com.javacode2018.springmvc.chat20.config;

import com.javacode2018.springmvc.chat20.dto.UserDto;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@ComponentScan("com.javacode2018.springmvc.chat20")
@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, UserDto>() {
            @Override
            public UserDto convert(String source) {
                if (source == null) {
                    return null;
                }
                String[] split = source.split(",");
                String name = split[0];
                Integer age = Integer.valueOf(split[1]);
                return new UserDto(name, age);
            }
        });
    }
}
