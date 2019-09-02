package com.cskaoyan.wdjava.admin.mapper;

import com.cskaoyan.wdjava.admin.bean.AdminAddGoods;
import com.cskaoyan.wdjava.admin.bean.AdminType;
import com.cskaoyan.wdjava.admin.bean.UpdateGoods;
import com.cskaoyan.wdjava.vue.bean.Good;
import com.cskaoyan.wdjava.vue.bean.Specs;
import com.cskaoyan.wdjava.vue.vo.GoodRes;
import com.cskaoyan.wdjava.vue.vo.TypeRes;

import java.util.List;

public interface AdminGoodsMapper {

    List<TypeRes> getType();

    List<GoodRes> getGoodsByType(Integer typeId);

    List<AdminType> selectAllType();

    void addType(String name);

    void updateType();

    void insertGoods(AdminAddGoods adminAddGoods);

    void insertGoodsDetail(Specs specs);

    void deleteGoodsById(Integer id);

    void deleteGoodsDetailById(Integer id);

    Good getGoodsInfoById(Integer id);

    List<Specs> selectSpecsById(Integer id);

    void updateGoods(UpdateGoods updateGoods);

    void updateGoodsDetail(Specs specs);

    void deleteOrderByGoodsId(Integer id);

    void deleteMessageByGoodsId(Integer id);

    List<String> selectGoodsDetailByGoodsId(int parseInt);

    void deleteSpec(int parseInt, String specName);
}
