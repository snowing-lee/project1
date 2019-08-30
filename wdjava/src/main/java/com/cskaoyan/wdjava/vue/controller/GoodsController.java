package com.cskaoyan.wdjava.vue.controller;

import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.service.GoodService;
import com.cskaoyan.wdjava.vue.vo.GoodReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/good")
public class GoodsController {

    @Autowired
    GoodService goodService;

    @RequestMapping(value = "/api/mall/getGoodsByType" , method = RequestMethod.GET)
    public BaseRes getGoodsByType(GoodReq goodReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = goodService.getGoodsByType(goodReq);
        }catch (Exception e) {
        }finally {
        }

       return baseRes;
    }

    @RequestMapping(value = "/api/mall/getGoodsInfo" , method = RequestMethod.GET)
    public BaseRes getGoodsInfo(GoodReq goodReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = goodService.getGoodsInfo(goodReq);
        }catch (Exception e) {
        }finally {
        }

        return baseRes;
    }

    @RequestMapping(value = "/api/mall/getGoodsMsg" , method = RequestMethod.GET)
    public BaseRes getGoodsMsg(GoodReq goodReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = goodService.getGoodsMsg(goodReq);
        }catch (Exception e) {
        }finally {
        }
        return baseRes;
    }

    @RequestMapping(value = "/api/mall/getGoodsComment" , method = RequestMethod.GET)
    public BaseRes getGoodsComment(GoodReq goodReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = goodService.getGoodsComment(goodReq);
        }catch (Exception e) {
        }finally {
        }
        return baseRes;
    }
}
