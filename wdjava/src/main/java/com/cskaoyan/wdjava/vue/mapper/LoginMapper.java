package com.cskaoyan.wdjava.vue.mapper;

import com.cskaoyan.wdjava.vue.bean.Login;
import com.cskaoyan.wdjava.vue.vo.LoginReq;
import com.cskaoyan.wdjava.vue.vo.LoginRes;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {

    Login login(String account);

    void signup(LoginReq loginReq);


    LoginRes data(String token);

    String checkPwd(int id);

    void updatePwd(@Param("id") int parseInt,
                   @Param("newPwd") String newPwd);
}
