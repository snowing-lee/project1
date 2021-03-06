package com.cskaoyan.wdjava.vue.mapper;

import com.cskaoyan.wdjava.vue.bean.Good;
import com.cskaoyan.wdjava.vue.bean.Order;
import com.cskaoyan.wdjava.vue.vo.CommentReq;
import com.cskaoyan.wdjava.vue.vo.OrderReq;
import com.cskaoyan.wdjava.vue.vo.OrderRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    void addOrder(Order order);

    Integer getGoodsDetailNumById(Integer goodsDetailId);

    void reduceGoodsDetailNumById(Order order);

    void reduceGoodsNumById(Order order);

    List<OrderRes> getOrderByState(OrderReq orderReq);

    List<Integer> selectCommentByOrderId(Integer id);

    Good selectGoodByGoodsDetailId(Integer goodsDetailId);

    void deleteOrder(Integer id);


    Order getOrderById(Integer id);

    void addGoodDetail(@Param("goodsDetailId") Integer goodsDetailId,
                       @Param("addNum") Integer addNum);

    void addGood(@Param("goodsDetailId")Integer goodsDetailId,
                 @Param("addNum")Integer addNum);

    void reduceGoodDetail(@Param("goodsDetailId")Integer goodsDetailId,
                          @Param("less")Integer less);

    void reduceGood(@Param("goodsDetailId")Integer goodsDetailId,
                    @Param("less")Integer less);

    void overOrder(Integer id);

    void confirmReceiveOrderById(Integer id);

    void insertComment(CommentReq commentReq);

    void payOrderById(Integer id);

    void updateGoodsDetail(Order order);
}
