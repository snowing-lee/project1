package com.cskaoyan.wdjava.admin.controller;

import com.cskaoyan.wdjava.admin.bean.ChangeOrder;
import com.cskaoyan.wdjava.admin.bean.OrdersLimit;
import com.cskaoyan.wdjava.admin.service.AdminOrderService;
import com.cskaoyan.wdjava.admin.vo.AdminOrderReq;
import com.cskaoyan.wdjava.base.BaseRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminOrderController {

    @Autowired
    AdminOrderService adminOrderService;

    @RequestMapping(value = "/api/admin/orders" , method = RequestMethod.GET)
    public BaseRes orders(AdminOrderReq adminOrderReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminOrderService.orders(adminOrderReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

       return baseRes;
    }

    @RequestMapping(value = "/api/admin/ordersByPage" , method = RequestMethod.POST)
    public BaseRes ordersByPage(@RequestBody AdminOrderReq adminOrderReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminOrderService.ordersByPage(adminOrderReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }

    @RequestMapping(value = "/api/admin/deleteOrder" , method = RequestMethod.GET)
    public BaseRes deleteOrder(AdminOrderReq adminOrderReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminOrderService.deleteOrder(adminOrderReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }

    @RequestMapping(value = "/api/admin/order" , method = RequestMethod.GET)
    public BaseRes order(AdminOrderReq adminOrderReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminOrderService.order(adminOrderReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }

    @RequestMapping(value = "/api/admin/changeOrder" , method = RequestMethod.POST)
    public BaseRes changeOrder(@RequestBody ChangeOrder changeOrder){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminOrderService.changeOrder(changeOrder);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }


}
