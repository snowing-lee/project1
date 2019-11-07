package com.cskaoyan.wdjava.admin.service;


import com.cskaoyan.wdjava.admin.bean.AdminLogin;
import com.cskaoyan.wdjava.admin.bean.ChangePwd;
import com.cskaoyan.wdjava.admin.vo.AdminLoginReq;
import com.cskaoyan.wdjava.base.BaseRes;

public interface AdminLoginService {

    public BaseRes login(AdminLoginReq loginReq)throws Exception;

    public BaseRes deleteUser(AdminLoginReq loginReq) throws Exception;

    public BaseRes changePwd(ChangePwd changePwd) throws Exception;

    public BaseRes deleteAdmins(AdminLoginReq loginReq) throws Exception;

    public BaseRes addAdminss(AdminLogin adminLogin) throws Exception;

    public BaseRes updateAdminss(AdminLogin adminLogin) throws Exception;

    public BaseRes logoutAdmin(AdminLoginReq loginReq) throws Exception;
}
