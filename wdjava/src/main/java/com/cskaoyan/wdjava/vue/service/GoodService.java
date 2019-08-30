package com.cskaoyan.wdjava.vue.service;


import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.vo.GoodReq;

public interface GoodService {

    public BaseRes getGoodsByType(GoodReq goodReq) throws Exception;

    public BaseRes getGoodsInfo(GoodReq goodReq) throws Exception;

    public BaseRes getGoodsMsg(GoodReq goodReq) throws Exception;

    public BaseRes getGoodsComment(GoodReq goodReq) throws Exception;
}
