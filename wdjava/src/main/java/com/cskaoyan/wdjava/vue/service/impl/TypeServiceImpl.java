package com.cskaoyan.wdjava.vue.service.impl;

import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.mapper.TypeMapper;
import com.cskaoyan.wdjava.vue.service.TypeService;
import com.cskaoyan.wdjava.vue.vo.TypeRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeMapper typeMapper;

    @Override
    public BaseRes getType() throws Exception {
        BaseRes baseRes = new BaseRes();

        List<TypeRes> list = typeMapper.getType();

        baseRes.setCode(0);
        baseRes.setData(list);
        return baseRes;
    }
}
