package com.cskaoyan.wdjava.admin.mapper;

import com.cskaoyan.wdjava.admin.bean.AdminSelect;
import com.cskaoyan.wdjava.admin.vo.AdminSelectReq;

import java.util.List;

public interface AdminSelectMapper {

    List<AdminSelect> allUser();

    List<AdminSelect> searchUser(String word);

    List<AdminSelect> allAdmins();

    List<AdminSelect> getSearchAdmins(AdminSelectReq adminSelectReq);

    AdminSelect getAdminsInfo(Integer id);
}
