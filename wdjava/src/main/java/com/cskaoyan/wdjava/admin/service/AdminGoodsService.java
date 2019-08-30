package com.cskaoyan.wdjava.admin.service;


import com.cskaoyan.wdjava.admin.bean.AddSpec;
import com.cskaoyan.wdjava.admin.bean.AdminAddGoods;
import com.cskaoyan.wdjava.admin.bean.UpdateGoods;
import com.cskaoyan.wdjava.admin.vo.AdminGoodsReq;
import com.cskaoyan.wdjava.base.BaseRes;

public interface AdminGoodsService {

    public BaseRes getType() throws Exception;

    public BaseRes getGoodsByType(AdminGoodsReq adminGoodsReq) throws Exception;

    public BaseRes addType(AdminGoodsReq adminGoodsReq) throws Exception;

    public BaseRes addGoods(AdminAddGoods adminAddGoods) throws Exception;

    public BaseRes deleteGoods(AdminAddGoods adminAddGoods)throws Exception;

    public BaseRes getGoodsInfo(AdminAddGoods adminAddGoods) throws Exception;

    public BaseRes updateGoods(UpdateGoods updateGoods) throws Exception;

    public BaseRes addSpec(AddSpec addSpec) throws Exception;
}
