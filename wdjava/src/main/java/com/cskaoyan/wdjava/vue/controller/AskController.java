package com.cskaoyan.wdjava.vue.controller;

import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.service.AskService;
import com.cskaoyan.wdjava.vue.vo.AskReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController {

    @Autowired
    AskService askService;

    @RequestMapping(value = "/api/mall/askGoodsMsg" , method = RequestMethod.POST)
    public BaseRes askGoodsMsg(@RequestBody AskReq askReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = askService.askGoodsMsg(askReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

       return baseRes;
    }

}
