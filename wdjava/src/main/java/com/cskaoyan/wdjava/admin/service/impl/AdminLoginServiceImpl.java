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
        String email = loginReq.getEmail();
        String pwd = loginReq.getPwd();

        AdminLogin adminLogin = loginMapper.selectMsgByAccount(email);
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
        adminLoginRes.setToken(adminLogin.getNickname());
        adminLoginRes.setName(adminLogin.getNickname());
        baseRes.setCode(0);
        baseRes.setData(adminLoginRes);
        return baseRes;
    }

    @Override
    public BaseRes deleteUser(AdminLoginReq loginReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = loginReq.getId();

        if (id != null && id == 1){
            baseRes.setCode(1000);
            baseRes.setMessage("你不能删除admin账号!");
            return baseRes;
        }

        // 同时删除对应留言等
        loginMapper.deleteOrderByUserId(id);
        loginMapper.deleteMessageByUserId(id);
        loginMapper.deleteReMessageByUserid(id);

        loginMapper.deleteUser(id);

        baseRes.setCode(0);
        return baseRes;
    }
    @Override
    public BaseRes deleteAdmins(AdminLoginReq loginReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = loginReq.getId();
        if (id != null && id == 1){
            baseRes.setCode(1000);
            baseRes.setMessage("你不能删除admin账号!");
            return baseRes;
        }

        loginMapper.deleteAdmins(id);

        baseRes.setCode(0);
        return baseRes;
    }

    @Override
    public BaseRes addAdminss(AdminLogin adminLogin) throws Exception {
        BaseRes baseRes = new BaseRes();
        String email = adminLogin.getEmail();
        Integer id = loginMapper.accountaccount(email);
        if (id != null && id>0 ){
            baseRes.setCode(10000);
            baseRes.setMessage("该账号不允许重复使用");
            return baseRes;
        }
        id = null;
        id = loginMapper.namemane(adminLogin.getNickname());
        if (id != null && id>0 ){
            baseRes.setCode(10000);
            baseRes.setMessage("该用户名不允许重复使用");
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
        String email = adminLogin.getEmail();
        if (email.equals("admin")){
            baseRes.setCode(10000);
            baseRes.setMessage("admin不允许修改");
            return baseRes;
        }
        Integer idres = loginMapper.accountaccount(email);
        if (idres != null && idres>0 ){
            if (id.intValue() != idres.intValue()){
                baseRes.setCode(10000);
                baseRes.setMessage("该账号不允许重复使用");
                return baseRes;
            }
        }
//        id = null;
        Integer ids = loginMapper.namemane(adminLogin.getNickname());
        if (ids != null && ids>0 ){
            if (ids.intValue() != id.intValue()) {
                baseRes.setCode(10000);
                baseRes.setMessage("该用户名不允许重复使用");
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
    public BaseRes logoutAdmin(AdminLoginReq loginReq) throws Exception {
        BaseRes baseRes = new BaseRes();
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
