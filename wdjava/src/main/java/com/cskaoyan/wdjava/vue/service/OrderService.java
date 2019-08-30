package com.cskaoyan.wdjava.vue.service;


import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.vo.OrderReq;

import java.util.List;

public interface OrderService {

    public BaseRes addOrder(OrderReq orderReq)throws Exception;

    public  BaseRes getOrderByState(OrderReq orderReq)throws Exception;

    public  BaseRes deleteOrder(OrderReq orderReq)throws Exception;

    public  BaseRes settleAccounts(List<OrderReq> cartList)throws Exception;
}
