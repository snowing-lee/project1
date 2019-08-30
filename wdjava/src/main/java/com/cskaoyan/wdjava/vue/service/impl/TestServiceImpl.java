package com.cskaoyan.wdjava.vue.service.impl;

import com.cskaoyan.wdjava.vue.bean.Test;
import com.cskaoyan.wdjava.vue.mapper.TestMapper;
import com.cskaoyan.wdjava.vue.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public List<Test> test() throws Exception {

        List<Test> tests =  testMapper.select();
        return tests;
    }

}
