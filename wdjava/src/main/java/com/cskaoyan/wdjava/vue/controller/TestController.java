package com.cskaoyan.wdjava.vue.controller;

import com.cskaoyan.wdjava.vue.bean.Test;
import com.cskaoyan.wdjava.vue.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/test1")
    public List test1(){
        List<Test> tests = new ArrayList<>();
        try{
            tests = testService.test();
        }catch (Exception e) {
        }finally {
        }

       return tests;
    }
}
