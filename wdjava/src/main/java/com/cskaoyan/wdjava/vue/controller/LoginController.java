package com.cskaoyan.wdjava.vue.controller;

import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.bean.UpdatePwd;
import com.cskaoyan.wdjava.vue.service.LoginService;
import com.cskaoyan.wdjava.vue.vo.LoginReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/good")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/api/user/login" , method = RequestMethod.POST)
    public BaseRes login(@RequestBody LoginReq loginReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = loginService.login(loginReq);
        }catch (Exception e) {
        }finally {
        }

       return baseRes;
    }

    @RequestMapping(value = "/api/user/signup" , method = RequestMethod.POST)
    public BaseRes signup(@RequestBody LoginReq loginReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = loginService.signup(loginReq);
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }finally {
        }

        return baseRes;
    }

    @RequestMapping(value = "/api/user/data" , method = RequestMethod.GET)
    public BaseRes data(LoginReq loginReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = loginService.data(loginReq);
        }catch (Exception e) {
        }finally {
        }
        return baseRes;
    }


    @RequestMapping(value = "/api/user/updatePwd" , method = RequestMethod.POST)
    public BaseRes updatePwd(@RequestBody UpdatePwd updatePwd){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = loginService.updatePwd(updatePwd);
        }catch (Exception e) {
        }finally {
        }
        return baseRes;
    }


    @RequestMapping(value = "/api/user/updateUserData" , method = RequestMethod.POST)
    public BaseRes updateUserData(@RequestBody LoginReq loginReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = loginService.updateUserData(loginReq);
        }catch (Exception e) {
        }finally {
        }
        return baseRes;
    }
}
