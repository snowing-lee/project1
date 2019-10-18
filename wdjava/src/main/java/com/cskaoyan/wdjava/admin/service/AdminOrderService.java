package com.cskaoyan.wdjava.admin.service;


import com.cskaoyan.wdjava.admin.bean.ChangeOrder;
import com.cskaoyan.wdjava.admin.bean.OrdersLimit;
import com.cskaoyan.wdjava.admin.vo.AdminOrderReq;
import com.cskaoyan.wdjava.base.BaseRes;

public interface AdminOrderService {

    public BaseRes orders(AdminOrderReq adminOrderReq) throws Exception;

    public BaseRes deleteOrder(AdminOrderReq adminOrderReq) throws Exception;

    public BaseRes order(AdminOrderReq adminOrderReq) throws Exception;

    public BaseRes changeOrder(ChangeOrder changeOrder) throws Exception;

    public BaseRes ordersByPage(AdminOrderReq adminOrderReq) throws Exception;

}
