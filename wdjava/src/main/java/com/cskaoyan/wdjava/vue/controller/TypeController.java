package com.cskaoyan.wdjava.vue.controller;

import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/type")
public class TypeController {

    @Autowired
    TypeService typeService;

    @RequestMapping("/api/admin/getType")
    public BaseRes getType(){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = typeService.getType();
        }catch (Exception e) {
        }finally {
        }

       return baseRes;
    }
}
