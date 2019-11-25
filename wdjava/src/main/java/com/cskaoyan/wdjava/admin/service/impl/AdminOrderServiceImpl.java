package com.cskaoyan.wdjava.admin.service.impl;

import com.cskaoyan.wdjava.admin.bean.*;
import com.cskaoyan.wdjava.admin.mapper.AdminOrderMapper;
import com.cskaoyan.wdjava.admin.service.AdminOrderService;
import com.cskaoyan.wdjava.admin.vo.AdminOrderReq;
import com.cskaoyan.wdjava.admin.vo.AdminOrderRes;
import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.bean.Good;
import com.cskaoyan.wdjava.vue.bean.Specs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class AdminOrderServiceImpl implements AdminOrderService {

    @Autowired
    AdminOrderMapper adminOrderMapper;
    @Override
    public BaseRes ordersByPage(AdminOrderReq adminOrderReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer state = adminOrderReq.getState();
        Integer pagesize = adminOrderReq.getPagesize();//条目数
        Integer currentPage = adminOrderReq.getCurrentPage(); // 第几页
        Integer limit = pagesize*(currentPage-1);
        adminOrderReq.setLimit(limit);

        Integer id = adminOrderReq.getId();
        String name = adminOrderReq.getName();
        String address = adminOrderReq.getAddress();
        String goods = adminOrderReq.getGoods();
        Double moneyLimit1 = adminOrderReq.getMoneyLimit1();
        Double moneyLimit2 = adminOrderReq.getMoneyLimit2();

        List<AdminOrderRes> totollist = adminOrderMapper.getOrders(adminOrderReq);
        int total = totollist.size();


        List<AdminOrderRes> list = adminOrderMapper.ordersByPage(adminOrderReq);
        for (AdminOrderRes adminOrderRes : list) {
            Integer stateId = adminOrderRes.getStateId();
            switch (stateId){
                case 0:
                    adminOrderRes.setState("未付款");
                    break;
                case 1:
                    adminOrderRes.setState("未发货");
                    break;
                case 2:
                    adminOrderRes.setState("已发货");
                    break;
                case 3:
                    adminOrderRes.setState("已到货");
                    break;
                default:
                    adminOrderRes.setState("信息出错");
            }

            Integer goodsDetailId = adminOrderRes.getGoodsDetailId();
            Good good = adminOrderMapper.getGoodsDetailByDetailId(goodsDetailId);
            if (good != null){
                adminOrderRes.setGoods(good.getName());
                adminOrderRes.setSpec(good.getSpec());
            }else {
                adminOrderRes.setGoods("已下架");
                adminOrderRes.setSpec("已下架");
            }

            Integer userId = adminOrderRes.getUserId();
            AdminUser user = adminOrderMapper.selectUserByUserId(userId);
            adminOrderRes.setUser(user);
        }

        HashMap<Object, Object> map = new HashMap<>();
        map.put("orders",list);
        map.put("total",total);

        baseRes.setCode(0);
        baseRes.setData(map);
        return baseRes;
    }
    @Override
    public BaseRes orders(AdminOrderReq adminOrderReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer state = adminOrderReq.getState();

        List<AdminOrderRes> list = adminOrderMapper.getOrdersfirst(state);
        for (AdminOrderRes adminOrderRes : list) {
            Integer stateId = adminOrderRes.getStateId();
            switch (stateId){
                case 0:
                    adminOrderRes.setState("未付款");
                    break;
                case 1:
                    adminOrderRes.setState("未发货");
                    break;
                case 2:
                    adminOrderRes.setState("已发货");
                    break;
                case 3:
                    adminOrderRes.setState("已发货");
                    break;
                default:
                    adminOrderRes.setState("信息出错");
            }

            Integer goodsDetailId = adminOrderRes.getGoodsDetailId();
            Good good = adminOrderMapper.getGoodsDetailByDetailId(goodsDetailId);
            if (good != null){
                adminOrderRes.setGoods(good.getName());
                adminOrderRes.setSpec(good.getSpec());
            }else {
                adminOrderRes.setGoods("已下架");
                adminOrderRes.setSpec("已下架");
            }

            Integer userId = adminOrderRes.getUserId();
            AdminUser user = adminOrderMapper.selectUserByUserId(userId);
            adminOrderRes.setUser(user);
        }

        baseRes.setCode(0);
        baseRes.setData(list);
        return baseRes;
    }

    @Override
    public BaseRes deleteOrder(AdminOrderReq adminOrderReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = adminOrderReq.getId();

        adminOrderMapper.deleteOrderByOrderId(id);

        baseRes.setCode(0);
        return baseRes;
    }

    @Override
    public BaseRes order(AdminOrderReq adminOrderReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = adminOrderReq.getId();

        AdminOrder res = adminOrderMapper.getOrder(id);
        Integer goodsDetailId = res.getGoodsDetailId();
        Integer state = res.getState();

        List<AdminStates> listStates =  new ArrayList<>();
        AdminStates states0 = new AdminStates(0, "未付款");
        AdminStates states1 = new AdminStates(1, "未发货");
        AdminStates states2 = new AdminStates(2, "已发货");
        AdminStates states3 = new AdminStates(3, "已完成订单");
        listStates.add(states0);
        listStates.add(states1);
        listStates.add(states2);
        listStates.add(states3);
        res.setStates(listStates);

        // 该goodsDetailId下货物的所有规格
        List<Specs> listSpecs = adminOrderMapper.selectGoodsDetailsByDetailId(goodsDetailId);
        res.setSpec(listSpecs);


        String goodsName = adminOrderMapper.selectGoodsNameByDetailId(goodsDetailId);
        res.setGoods(goodsName);

        //标记状态(规格)
        AdminCurState adminCurState = new AdminCurState();
        adminCurState.setId(state);
        res.setCurState(adminCurState);

        //标记状态(订单)
        AdminCurState adminCurState1 = new AdminCurState();
        adminCurState1.setId(goodsDetailId);
        res.setCurSpec(adminCurState1);

        baseRes.setCode(0);
        baseRes.setData(res);
        return baseRes;
    }

    @Override
    public BaseRes changeOrder(ChangeOrder changeOrder) throws Exception {
        BaseRes baseRes = new BaseRes();
        String id = changeOrder.getId();
        Integer num = changeOrder.getNum();
        Integer spec = changeOrder.getSpec();
        Integer state = changeOrder.getState();

        adminOrderMapper.updateOrder(changeOrder);

        baseRes.setCode(0);
        return baseRes;
    }


}
