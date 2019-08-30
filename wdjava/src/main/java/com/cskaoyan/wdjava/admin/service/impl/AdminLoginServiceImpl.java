package com.cskaoyan.wdjava.admin.service.impl;

import com.cskaoyan.wdjava.admin.bean.AdminLogin;
import com.cskaoyan.wdjava.admin.bean.ChangePwd;
import com.cskaoyan.wdjava.admin.mapper.AdminLoginMapper;
import com.cskaoyan.wdjava.admin.service.AdminLoginService;
import com.cskaoyan.wdjava.admin.vo.AdminLoginReq;
import com.cskaoyan.wdjava.admin.vo.AdminLoginRes;
import com.cskaoyan.wdjava.base.BaseRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    AdminLoginMapper loginMapper;

    @Override
    public BaseRes login(AdminLoginReq loginReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        String account = loginReq.getAccount();
        String pwd = loginReq.getPwd();

        AdminLogin adminLogin = loginMapper.selectMsgByAccount(account);
        if (adminLogin == null){
            baseRes.setCode(10000);
            baseRes.setMessage("该账号不存在");
            return  baseRes;
        }

        String resPwd = adminLogin.getPwd();
        if (!pwd.equals(resPwd)){
            baseRes.setCode(10000);
            baseRes.setMessage("密码不正确!");
            return  baseRes;
        }

        AdminLoginRes adminLoginRes = new AdminLoginRes();
        adminLoginRes.setToken(adminLogin.getName());
        adminLoginRes.setName(adminLogin.getName());
        baseRes.setCode(0);
        baseRes.setData(adminLoginRes);
        return baseRes;
    }

    @Override
    public BaseRes deleteUser(AdminLoginReq loginReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = loginReq.getId();

        loginMapper.deleteUser(id);

        baseRes.setCode(0);
        return baseRes;
    }
    @Override
    public BaseRes deleteAdmins(AdminLoginReq loginReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = loginReq.getId();

        loginMapper.deleteAdmins(id);

        baseRes.setCode(0);
        return baseRes;
    }

    @Override
    public BaseRes addAdminss(AdminLogin adminLogin) throws Exception {
        BaseRes baseRes = new BaseRes();
        String account = adminLogin.getAccount();
        Integer id = loginMapper.accountaccount(account);
        if (id != null && id>0 ){
            baseRes.setCode(10000);
            baseRes.setMessage("该账号不允许重复使用");
            return baseRes;
        }

        String name = adminLogin.getName();
        String pwd = adminLogin.getPwd();


        loginMapper.addAdminss(adminLogin);

        baseRes.setCode(0);
        return baseRes;
    }

    @Override
    public BaseRes updateAdminss(AdminLogin adminLogin) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = adminLogin.getId();
        String account = adminLogin.getAccount();
        Integer idres = loginMapper.accountaccount(account);
        if (idres != null && id>0 ){
            if (id != idres){
                baseRes.setCode(10000);
                baseRes.setMessage("该账号不允许重复使用");
                return baseRes;
            }
        }
        String name = adminLogin.getName();
        String pwd = adminLogin.getPwd();

        loginMapper.updateAdminss(adminLogin);

        baseRes.setCode(0);
        return baseRes;
    }

    @Override
    public BaseRes changePwd(ChangePwd changePwd) throws Exception {
        BaseRes baseRes = new BaseRes();
        String adminToken = changePwd.getAdminToken();
        String oldPwd = changePwd.getOldPwd();
        String newPwd = changePwd.getNewPwd();
        String confirmPwd = changePwd.getConfirmPwd();

        ChangePwd res = loginMapper.selectAdminByTokenName(adminToken);
        if (res == null){
            baseRes.setCode(10000);
            baseRes.setMessage("出现异常");
            return baseRes;
        }

        if (!res.getOldPwd().equals(oldPwd)){
            baseRes.setCode(10000);
            baseRes.setMessage("旧密码错误!");
            return baseRes;
        }

        if (!newPwd.equals(confirmPwd)){
            baseRes.setCode(10000);
            baseRes.setMessage("请保持确认新密码一致!");
            return baseRes;
        }

        loginMapper.updatePwd(changePwd);


        baseRes.setCode(0);
        return baseRes;
    }


}
