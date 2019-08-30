package com.cskaoyan.wdjava.admin.service.impl;

import com.cskaoyan.wdjava.admin.bean.AdminSelect;
import com.cskaoyan.wdjava.admin.mapper.AdminSelectMapper;
import com.cskaoyan.wdjava.admin.service.AdminSelectService;
import com.cskaoyan.wdjava.admin.vo.AdminSelectReq;
import com.cskaoyan.wdjava.base.BaseRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminSelectServiceImpl implements AdminSelectService {

    @Autowired
    AdminSelectMapper adminSelectMapper;

    @Override
    public BaseRes allUser() throws Exception {
        BaseRes baseRes = new BaseRes();

        List<AdminSelect> list = adminSelectMapper.allUser();

        baseRes.setCode(0);
        baseRes.setData(list);
        return baseRes;
    }

    @Override
    public BaseRes allAdmins() throws Exception {
        BaseRes baseRes = new BaseRes();

        List<AdminSelect> list = adminSelectMapper.allAdmins();

        baseRes.setCode(0);
        baseRes.setData(list);
        return baseRes;
    }

    @Override
    public BaseRes getSearchAdmins(AdminSelectReq adminSelectReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        String account = adminSelectReq.getAccount();
        String name = adminSelectReq.getName();

        List<AdminSelect> list = adminSelectMapper.getSearchAdmins(adminSelectReq);

        baseRes.setCode(0);
        baseRes.setData(list);
        return baseRes;
    }

    @Override
    public BaseRes getAdminsInfo(AdminSelectReq adminSelectReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = adminSelectReq.getId();

        AdminSelect getAdminsInfo = adminSelectMapper.getAdminsInfo(id);

        baseRes.setCode(0);
        baseRes.setData(getAdminsInfo);
        return baseRes;
    }

    @Override
    public BaseRes searchUser(AdminSelectReq adminSelectReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        String word = adminSelectReq.getWord();

        List<AdminSelect> list = adminSelectMapper.searchUser(word);

        baseRes.setCode(0);
        baseRes.setData(list);
        return baseRes;
    }


}
