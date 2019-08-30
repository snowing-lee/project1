package com.cskaoyan.wdjava.admin.bean;

import com.cskaoyan.wdjava.vue.bean.Specs;

import java.util.List;

public class AdminOrder {

    private Integer id;
    private Float amount;
    private Integer num;
    private Integer goodsDetailId;
    private Integer state;

    private String goods; // 商品名

    private List<Specs> spec;  // 规格
    private List<AdminStates> states; // 状态
    private AdminCurState curState;
    private AdminCurState curSpec;


    public AdminCurState getCurSpec() {
        return curSpec;
    }

    public void setCurSpec(AdminCurState curSpec) {
        this.curSpec = curSpec;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public List<Specs> getSpec() {
        return spec;
    }

    public void setSpec(List<Specs> spec) {
        this.spec = spec;
    }

    public List<AdminStates> getStates() {
        return states;
    }

    public void setStates(List<AdminStates> states) {
        this.states = states;
    }

    public AdminCurState getCurState() {
        return curState;
    }

    public void setCurState(AdminCurState curState) {
        this.curState = curState;
    }
}
