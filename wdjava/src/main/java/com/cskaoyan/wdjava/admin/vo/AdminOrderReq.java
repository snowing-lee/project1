package com.cskaoyan.wdjava.admin.vo;

import com.cskaoyan.wdjava.admin.bean.OrdersLimit;

public class AdminOrderReq  extends OrdersLimit {

    private Integer state;
    private Integer id;
    private Integer limit;

    private Integer currentPage;
    private Integer pagesize;

    private Double moneyLimit1;
    private Double moneyLimit2;
    private String goods;
    private String address;
    private String name;

    public Double getMoneyLimit1() {
        return moneyLimit1;
    }

    public void setMoneyLimit1(Double moneyLimit1) {
        this.moneyLimit1 = moneyLimit1;
    }

    public Double getMoneyLimit2() {
        return moneyLimit2;
    }

    public void setMoneyLimit2(Double moneyLimit2) {
        this.moneyLimit2 = moneyLimit2;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
