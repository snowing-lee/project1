package com.cskaoyan.wdjava.admin.bean;

import com.cskaoyan.wdjava.vue.bean.Specs;

import java.util.List;

public class UpdateGoods {
    private String id;
    private String desc;
    private String img;
    private String name;
    private Integer typeId;
    private Integer sumStock =  0;
    private Float minimumPrice = 0.0f;

    private List<Specs> specList;


    public Integer getSumStock() {
        return sumStock;
    }

    public void setSumStock(Integer sumStock) {
        this.sumStock = sumStock;
    }

    public Float getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Float minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public List<Specs> getSpecList() {
        return specList;
    }

    public void setSpecList(List<Specs> specList) {
        this.specList = specList;
    }
}
