package com.cskaoyan.wdjava.vue.controller;

import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.bean.Accounts;
import com.cskaoyan.wdjava.vue.service.OrderService;
import com.cskaoyan.wdjava.vue.vo.CommentReq;
import com.cskaoyan.wdjava.vue.vo.OrderReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/api/mall/addOrder" , method = RequestMethod.POST)
    public BaseRes addOrder(@RequestBody OrderReq orderReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = orderService.addOrder(orderReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

       return baseRes;
    }

    @RequestMapping(value = "/api/mall/getOrderByState" , method = RequestMethod.GET)
    public BaseRes getOrderByState(OrderReq orderReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = orderService.getOrderByState(orderReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

        return baseRes;
    }

    @RequestMapping(value = "/api/mall/deleteOrder" , method = RequestMethod.GET)
    public BaseRes deleteOrder(OrderReq orderReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = orderService.deleteOrder(orderReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }
        return baseRes;
    }


    @RequestMapping(value = "/api/mall/settleAccounts" , method = RequestMethod.POST)
    public BaseRes settleAccounts(@RequestBody Accounts accounts){
        BaseRes baseRes = new BaseRes();
        try{
            List<OrderReq> cartList = accounts.getCartList();
            baseRes = orderService.settleAccounts(cartList);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }
        return baseRes;
    }



    @RequestMapping(value = "/api/mall/confirmReceive" , method = RequestMethod.GET)
    public BaseRes confirmReceive(OrderReq orderReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes =  orderService.confirmReceive(orderReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }
        return baseRes;
    }





    @RequestMapping(value = "/api/mall/sendComment" , method = RequestMethod.POST)
    public BaseRes sendComment(@RequestBody CommentReq commentReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes =  orderService.sendComment(commentReq);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }
        return baseRes;
    }

}
