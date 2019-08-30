package com.cskaoyan.wdjava.vue.service;


import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.vo.SearchReq;

public interface SearchService {

    public BaseRes searchGoods(SearchReq searchReq) throws Exception;
}
