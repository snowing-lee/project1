package com.cskaoyan.wdjava.vue.service.impl;

import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.mapper.SearchMapper;
import com.cskaoyan.wdjava.vue.service.SearchService;
import com.cskaoyan.wdjava.vue.vo.GoodRes;
import com.cskaoyan.wdjava.vue.vo.SearchReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    SearchMapper searchMapper;

    @Override
    public BaseRes searchGoods(SearchReq searchReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        String keyword = searchReq.getKeyword();

        List<GoodRes> list = searchMapper.searchGoods(keyword);

        baseRes.setCode(0);
        baseRes.setData(list);
        return baseRes;
    }
}
