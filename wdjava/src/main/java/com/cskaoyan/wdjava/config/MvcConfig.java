package com.cskaoyan.wdjava.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 图片路径映射  /static/image/   --->  filePath
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Value("${wd.uploadPath}")
    String filePath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/image/**").addResourceLocations("file:"+filePath);
    }
}
