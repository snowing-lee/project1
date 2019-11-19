package com.cskaoyan.wdjava.vue.controller;

import com.cskaoyan.wdjava.vue.bean.Test;
import com.cskaoyan.wdjava.vue.service.TestService;
import com.cskaoyan.wdjava.vue.vo.OrderReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/test1" , method = RequestMethod.GET)
    public void test1(Test test, HttpServletResponse response) throws IOException {

        System.out.println(test);

//        response.sendRedirect("http://192.168.2.100:8080/");

        response.sendRedirect("http://baidu.com/");

    }
}
