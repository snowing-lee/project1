package com.cskaoyan.wdjava.vue.service;


import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.vo.AskReq;

public interface AskService {

    public BaseRes askGoodsMsg(AskReq askReq)throws Exception;
}
