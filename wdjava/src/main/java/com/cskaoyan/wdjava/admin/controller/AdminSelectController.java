package com.cskaoyan.wdjava.admin.controller;

import com.cskaoyan.wdjava.admin.service.AdminSelectService;
import com.cskaoyan.wdjava.admin.vo.AdminSelectReq;
import com.cskaoyan.wdjava.base.BaseRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminSelectController {

    @Autowired
    AdminSelectService adminSelectService;

    @RequestMapping(value = "/api/admin/allUser" , method = RequestMethod.GET)
    public BaseRes allUser(){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminSelectService.allUser();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

       return baseRes;
    }

    @RequestMapping(value = "/api/admin/allAdmins" , method = RequestMethod.GET)
    public BaseRes allAdmins(){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminSelectService.allAdmins();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }


    @RequestMapping(value = "/api/admin/getSearchAdmins" , method = RequestMethod.POST)
    public BaseRes getSearchAdmins(@RequestBody AdminSelectReq adminSelectReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminSelectService.getSearchAdmins(adminSelectReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }


    @RequestMapping(value = "/api/admin/getAdminsInfo" , method = RequestMethod.GET)
    public BaseRes getAdminsInfo(AdminSelectReq adminSelectReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminSelectService.getAdminsInfo(adminSelectReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }
    @RequestMapping(value = "/api/admin/searchUser" , method = RequestMethod.GET)
    public BaseRes searchUser(AdminSelectReq adminSelectReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminSelectService.searchUser(adminSelectReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }

}
