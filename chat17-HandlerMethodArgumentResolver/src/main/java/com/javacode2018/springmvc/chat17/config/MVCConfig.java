package com.javacode2018.springmvc.chat17.config;

import com.javacode2018.springmvc.chat17.dto.PetDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */
@Configuration
@ComponentScan("com.javacode2018.springmvc.chat17")
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 定义文件上传类型的请求解析器
     *
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        //maxUploadSizePerFile:单个文件大小限制（byte）
        multipartResolver.setMaxUploadSizePerFile(10 * 1024 * 1024);
        //maxUploadSize：整个请求大小限制（byte）
        multipartResolver.setMaxUploadSizePerFile(100 * 1024 * 1024);
        return multipartResolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, PetDto>() {
            @Override
            public PetDto convert(String source) {
                if (source != null) {
                    String[] split = source.split(",");
                    PetDto pet = new PetDto();
                    pet.setName(split[0]);
                    pet.setAge(Integer.valueOf(split[1]));
                    return pet;
                }
                return null;
            }
        });
    }
}
