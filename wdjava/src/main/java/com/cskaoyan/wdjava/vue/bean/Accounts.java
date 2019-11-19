package com.cskaoyan.wdjava.vue.bean;

import com.cskaoyan.wdjava.vue.vo.OrderReq;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Accounts {

    List<OrderReq> cartList;

    public List<OrderReq> getCartList() {
        return cartList;
    }

    public void setCartList(List<OrderReq> cartList) {
        this.cartList = cartList;
    }
}
