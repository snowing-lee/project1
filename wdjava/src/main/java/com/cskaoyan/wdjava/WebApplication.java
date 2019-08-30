package com.cskaoyan.wdjava;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan({"com.cskaoyan.wdjava.admin.mapper", "com.cskaoyan.wdjava.vue.mapper"})
@EnableTransactionManagement
public class WebApplication  extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
