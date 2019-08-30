package com.cskaoyan.wdjava.admin.mapper;

import com.cskaoyan.wdjava.admin.bean.AdminLogin;
import com.cskaoyan.wdjava.admin.bean.AdminOrder;
import com.cskaoyan.wdjava.admin.bean.AdminUser;
import com.cskaoyan.wdjava.admin.bean.ChangeOrder;
import com.cskaoyan.wdjava.admin.vo.AdminOrderRes;
import com.cskaoyan.wdjava.vue.bean.Good;
import com.cskaoyan.wdjava.vue.bean.Specs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminOrderMapper {

    List<AdminOrderRes> getOrders(@Param("state") Integer state);
    List<AdminOrderRes> ordersByPage(@Param("state")Integer state,
                                     @Param("limit")Integer limit,
                                     @Param("pagesize")Integer pagesize);

    Good getGoodsDetailByDetailId(Integer goodsDetailId);

    AdminUser selectUserByUserId(Integer userId);

    void deleteOrderByOrderId(Integer id);

    AdminOrder getOrder(Integer id);

    List<Specs> selectGoodsDetailsByDetailId(Integer goodsDetailId);

    String selectGoodsNameByDetailId(Integer goodsDetailId);

    void updateOrder(ChangeOrder changeOrder);


}
