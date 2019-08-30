package com.cskaoyan.wdjava.vue.mapper;

import com.cskaoyan.wdjava.vue.bean.*;
import com.cskaoyan.wdjava.vue.vo.GoodRes;

import java.util.List;

public interface GoodMapper {

    List<GoodRes> getGoodsByType(Integer typeId);

    Good getGoodsInfoById(Integer id);

    List<Specs> selectSpecsById(Integer id);

    List<Messages> getGoodsMsg(Integer id);

    Reply getReplyByMsgId(Integer msgId);

    List<Comment> getGoodsComment(Integer goodsId);

    User selectUserBy(Integer userId);
}
