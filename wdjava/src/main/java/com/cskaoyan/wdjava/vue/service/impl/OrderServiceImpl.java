package com.cskaoyan.wdjava.vue.service.impl;

import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.bean.Good;
import com.cskaoyan.wdjava.vue.bean.User;
import com.cskaoyan.wdjava.vue.bean.Order;
import com.cskaoyan.wdjava.vue.mapper.AskMapper;
import com.cskaoyan.wdjava.vue.mapper.OrderMapper;
import com.cskaoyan.wdjava.vue.service.OrderService;
import com.cskaoyan.wdjava.vue.vo.OrderReq;
import com.cskaoyan.wdjava.vue.vo.OrderRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    AskMapper askMapper;


    @Override
    public BaseRes addOrder(OrderReq orderReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        float amount = orderReq.getAmount();
        Integer goodsDetailId = orderReq.getGoodsDetailId();
        Integer num = orderReq.getNum();
        Integer state = orderReq.getState();
        String token = orderReq.getToken();

        // 首先判断是否有足够件数
        Integer detailNum = orderMapper.getGoodsDetailNumById(goodsDetailId);
        if (detailNum< num || detailNum< 1){
            baseRes.setCode(1000);
            baseRes.setMessage("库存容量不够!");
            return baseRes;
        }

        User user = askMapper.getUserIdByNickName(token);
        Integer userId = user.getId();

        Order order = new Order();
        order.setAmount(amount);
        order.setGoodsDetailId(goodsDetailId);
        order.setNum(num);
        order.setState(state);
        order.setUserId(userId);
        orderMapper.addOrder(order);

        // 减少库存(加入购物车或者直接购买)
        orderMapper.reduceGoodsDetailNumById(order);
        orderMapper.reduceGoodsNumById(order);

        baseRes.setCode(0);
        return baseRes;
    }

    @Override
    public BaseRes getOrderByState(OrderReq orderReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer state = orderReq.getState();
        String token = orderReq.getToken();

        User user = askMapper.getUserIdByNickName(token);
        Integer userId = user.getId();

        // 获得订单
        orderReq.setUserId(userId);
        List<OrderRes> orders = orderMapper.getOrderByState(orderReq);

        for (OrderRes order : orders) {
            Integer goodsDetailId = order.getGoodsDetailId();
            // 判断是否有评论:"hasComment": false,
            List<Integer> ids = orderMapper.selectCommentByGoodsDetailId(goodsDetailId);
            if (ids!=null && ids.size()>0){
                order.setHasComment(true);
            }else {
                order.setHasComment(false);
            }
            //获得订单 对应种类货物
            Good good = orderMapper.selectGoodByGoodsDetailId(goodsDetailId);
            order.setGoods(good);
        }
        baseRes.setCode(0);
        baseRes.setData(orders);
        return baseRes;
    }

    @Override
    public BaseRes deleteOrder(OrderReq orderReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = orderReq.getId();

        orderMapper.deleteOrder(id);

        baseRes.setCode(0);
        return baseRes;
    }

    @Override
    public BaseRes settleAccounts(List<OrderReq> cartList) throws Exception {
        BaseRes baseRes = new BaseRes();
        for (OrderReq orderReq : cartList) {
            Integer id = orderReq.getId();// 订单id
            Integer goodsNum = orderReq.getGoodsNum();// 当前件数

            Order order = orderMapper.getOrderById(id);
            Integer num = order.getNum();
            if (num > goodsNum){
                // 订单减少
                //增加库存( goods  good明细)
                Integer addNum = num - goodsNum;
                Integer goodsDetailId = order.getGoodsDetailId();
                orderMapper.addGoodDetail(goodsDetailId,addNum);
                orderMapper.addGood(goodsDetailId,addNum);
                //完成订单

                orderMapper.overOrder(id);


            }else if (num < goodsNum){
                // 订单追加
                //判断库存是否足够 good明细
                Integer stockNum = order.getStockNum();
                if (stockNum >= goodsNum){//库存足够
                }else {//库存不够
                    baseRes.setCode(10000);
                    baseRes.setMessage("库存不足!");
                    return baseRes;
                }
                Integer less = goodsNum - num;// 库存要减少数量
                Integer goodsDetailId = order.getGoodsDetailId();
                //减少库存( goods  good明细)
                orderMapper.reduceGoodDetail(goodsDetailId,less);
                orderMapper.reduceGood(goodsDetailId,less);
                //完成订单
                orderMapper.overOrder(id);

            }else {
                //订单不变,完成订单
                orderMapper.overOrder(id);

            }


        }
        baseRes.setCode(0);
        return baseRes;
    }

}
