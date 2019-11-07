package com.cskaoyan.wdjava.vue.service;


import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.bean.UpdatePwd;
import com.cskaoyan.wdjava.vue.vo.LoginReq;

public interface LoginService {

    public BaseRes login(LoginReq loginReq) throws Exception;

    public BaseRes signup(LoginReq loginReq) throws Exception;

    public BaseRes data(LoginReq loginReq) throws Exception;

    public BaseRes updatePwd(UpdatePwd updatePwd) throws Exception;

    public BaseRes updateUserData(LoginReq loginReq) throws Exception;

    public BaseRes logoutClient(LoginReq loginReq) throws Exception;
}
