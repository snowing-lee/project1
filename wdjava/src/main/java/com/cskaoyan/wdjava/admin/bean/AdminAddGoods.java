package com.cskaoyan.wdjava.admin.bean;

import com.cskaoyan.wdjava.vue.bean.Specs;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class AdminAddGoods {
    private Integer id;
    private String desc; // 描述
    private String img; //图片地址
    private String name; // 商品名
    private String typeId; // 商品种类
    private Float unitPrice;
    private Integer stockNum;

    private List<Specs> specList;


    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public List<Specs> getSpecList() {
        return specList;
    }

    public void setSpecList(List<Specs> specList) {
        this.specList = specList;
    }
}
