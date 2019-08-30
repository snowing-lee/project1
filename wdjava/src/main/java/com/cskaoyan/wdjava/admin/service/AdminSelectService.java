package com.cskaoyan.wdjava.admin.service;


import com.cskaoyan.wdjava.admin.vo.AdminSelectReq;
import com.cskaoyan.wdjava.base.BaseRes;

public interface AdminSelectService {

    public BaseRes allUser() throws Exception;

    public BaseRes searchUser(AdminSelectReq adminSelectReq) throws Exception;

    public BaseRes allAdmins() throws Exception;

    public BaseRes getSearchAdmins(AdminSelectReq adminSelectReq) throws Exception;

    public BaseRes getAdminsInfo(AdminSelectReq adminSelectReq) throws Exception;
}
