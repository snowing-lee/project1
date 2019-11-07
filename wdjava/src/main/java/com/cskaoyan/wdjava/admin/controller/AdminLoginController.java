package com.cskaoyan.wdjava.admin.controller;

import com.cskaoyan.wdjava.admin.bean.AdminLogin;
import com.cskaoyan.wdjava.admin.bean.ChangePwd;
import com.cskaoyan.wdjava.admin.service.AdminLoginService;
import com.cskaoyan.wdjava.admin.vo.AdminLoginReq;
import com.cskaoyan.wdjava.base.BaseRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminLoginController {

    @Autowired
    AdminLoginService loginService;

    @RequestMapping(value = "/api/admin/login" , method = RequestMethod.POST)
    public BaseRes login(@RequestBody AdminLoginReq loginReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = loginService.login(loginReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

       return baseRes;
    }


    @RequestMapping(value = "/api/admin/logoutAdmin" , method = RequestMethod.POST)
    public BaseRes logoutAdmin(@RequestBody AdminLoginReq loginReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = loginService.logoutAdmin(loginReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }

    @RequestMapping(value = "/api/admin/deleteAdmins" , method = RequestMethod.GET)
    public BaseRes deleteAdmins(AdminLoginReq loginReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = loginService.deleteAdmins(loginReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }

    @RequestMapping(value = "/api/admin/deleteUser" , method = RequestMethod.GET)
    public BaseRes deleteUser(AdminLoginReq loginReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = loginService.deleteUser(loginReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }

    @RequestMapping(value = "/api/admin/changePwd" , method = RequestMethod.POST)
    public BaseRes changePwd(@RequestBody ChangePwd changePwd){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = loginService.changePwd(changePwd);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }




    @RequestMapping(value = "/api/admin/addAdminss" , method = RequestMethod.POST)
    public BaseRes addAdminss(@RequestBody AdminLogin adminLogin){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = loginService.addAdminss(adminLogin);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }


    @RequestMapping(value = "/api/admin/updateAdminss" , method = RequestMethod.POST)
    public BaseRes updateAdminss(@RequestBody AdminLogin adminLogin){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = loginService.updateAdminss(adminLogin);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }
}
