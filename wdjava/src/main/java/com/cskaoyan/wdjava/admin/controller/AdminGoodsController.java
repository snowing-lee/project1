package com.cskaoyan.wdjava.admin.controller;

import com.cskaoyan.wdjava.admin.bean.AddSpec;
import com.cskaoyan.wdjava.admin.bean.AdminAddGoods;
import com.cskaoyan.wdjava.admin.bean.UpdateGoods;
import com.cskaoyan.wdjava.admin.service.AdminGoodsService;
import com.cskaoyan.wdjava.admin.vo.AdminGoodsReq;
import com.cskaoyan.wdjava.base.BaseRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminGoodsController {

    @Autowired
    AdminGoodsService adminGoodsService;


    @RequestMapping(value = "/api/admin/getGoodsByType" , method = RequestMethod.GET)
    public BaseRes getGoodsByType(AdminGoodsReq adminGoodsReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminGoodsService.getGoodsByType(adminGoodsReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }

    @RequestMapping(value = "/api/admin/addType" , method = RequestMethod.POST)
    public BaseRes addType(@RequestBody AdminGoodsReq adminGoodsReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminGoodsService.addType(adminGoodsReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }

    @RequestMapping(value = "/api/admin/addGoods" , method = RequestMethod.POST)
    public BaseRes addGoods(@RequestBody AdminAddGoods adminAddGoods){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminGoodsService.addGoods(adminAddGoods);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }

    @RequestMapping(value = "/api/admin/deleteGoods" , method = RequestMethod.GET)
    public BaseRes deleteGoods(AdminAddGoods adminAddGoods){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminGoodsService.deleteGoods(adminAddGoods);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }

    @RequestMapping(value = "/api/admin/getGoodsInfo" , method = RequestMethod.GET)
    public BaseRes getGoodsInfo(AdminAddGoods adminAddGoods){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminGoodsService.getGoodsInfo(adminAddGoods);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }



    @RequestMapping(value = "/api/admin/updateGoods" , method = RequestMethod.POST)
    public BaseRes updateGoods(@RequestBody UpdateGoods updateGoods){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminGoodsService.updateGoods(updateGoods);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }


    @RequestMapping(value = "/api/admin/addSpec" , method = RequestMethod.POST)
    public BaseRes addSpec(@RequestBody AddSpec addSpec){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminGoodsService.addSpec(addSpec);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }
}
