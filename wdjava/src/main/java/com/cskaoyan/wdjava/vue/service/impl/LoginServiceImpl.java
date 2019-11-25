package com.cskaoyan.wdjava.vue.service.impl;

import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.bean.Login;
import com.cskaoyan.wdjava.vue.bean.UpdatePwd;
import com.cskaoyan.wdjava.vue.mapper.LoginMapper;
import com.cskaoyan.wdjava.vue.service.LoginService;
import com.cskaoyan.wdjava.vue.vo.LoginReq;
import com.cskaoyan.wdjava.vue.vo.LoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public BaseRes login(LoginReq loginReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        String account = loginReq.getEmail();
        String pwd = loginReq.getPwd();


        Login login = loginMapper.login(account);

        String pwdres= "";
        if (login!=null){
            pwdres = login.getPwd();
        }

        if (pwd!=null && pwd.equals(pwdres)){
            baseRes.setCode(0);
            LoginRes loginRes = new LoginRes();
            loginRes.setName(login.getNickname());
            loginRes.setToken(login.getNickname());
            baseRes.setData(loginRes);

        }else {
            baseRes.setCode(10000);
            baseRes.setMessage("账号或密码不正确!");
        }

        return baseRes;
    }

    @Override
    public BaseRes signup(LoginReq loginReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        String account = loginReq.getEmail();
        Login login = loginMapper.login(account);

        if (login!=null){
            baseRes.setCode(10000);
            baseRes.setMessage("该账号已存在!");
            return baseRes;
        }
        login = null;
        login = loginMapper.loginname(loginReq.getNickname());
        if (login!=null){
            baseRes.setCode(10000);
            baseRes.setMessage("该用户名已存在!");
            return baseRes;
        }

        try {
            loginMapper.signup(loginReq);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }

        baseRes.setCode(0);
        LoginRes loginRes = new LoginRes();
        loginRes.setName(loginReq.getNickname());
        loginRes.setToken(loginReq.getNickname());
        baseRes.setData(loginRes);

        return baseRes;
    }

    @Override
    public BaseRes data(LoginReq loginReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        String token = loginReq.getToken();

        LoginRes loginRes = loginMapper.data(token);

        baseRes.setCode(0);
        baseRes.setData(loginRes);
        return baseRes;
    }

    @Override
    public BaseRes updatePwd(UpdatePwd updatePwd) throws Exception {
        BaseRes baseRes = new BaseRes();
        String id = updatePwd.getId();
        String oldPwd = updatePwd.getOldPwd();
        String pwd = loginMapper.checkPwd(Integer.parseInt(id));
        if (pwd== null){
            baseRes.setCode(10000);
            baseRes.setMessage("信息出错!");
            return baseRes;
        }else if (!pwd.equals(oldPwd)){
            baseRes.setCode(10000);
            baseRes.setMessage("旧密码不正确!");
            return baseRes;
        }


        String newPwd = updatePwd.getNewPwd();
        String confirmPwd = updatePwd.getConfirmPwd();
        if (!newPwd.equals(confirmPwd)){
            baseRes.setCode(10000);
            baseRes.setMessage("两次输入不匹配!");
            return baseRes;
        }

        loginMapper.updatePwd(Integer.parseInt(id),newPwd);


        baseRes.setCode(0);
        return baseRes;
    }

    @Override
    public BaseRes updateUserData(LoginReq loginReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = loginReq.getId();
        String nickname = loginReq.getNickname();
        String address = loginReq.getAddress();
        String phone = loginReq.getPhone();
        String recipient = loginReq.getRecipient();
        if (nickname.equals("admin")){
            baseRes.setCode(10000);
            baseRes.setMessage("admin不允许修改");
            return baseRes;
        }
        loginMapper.updateUserData(loginReq);


        return baseRes;
    }

    @Override
    public BaseRes logoutClient(LoginReq loginReq) throws Exception {

        BaseRes baseRes = new BaseRes();
        return baseRes;
    }
}
