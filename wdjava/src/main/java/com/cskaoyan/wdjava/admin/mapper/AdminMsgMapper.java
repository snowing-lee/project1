package com.cskaoyan.wdjava.admin.mapper;

import com.cskaoyan.wdjava.admin.bean.*;

import java.util.List;

public interface AdminMsgMapper {

    List<AdminMsg> noReplyMsg();

    AdminAddGoods getGoodsByGoodsId(Integer goodsId);

    AdminUser getUserByUserId(Integer userId);

    List<AdminMsg> repliedMsg();

    void insertReply(AdminReply adminReply);

    void updateStateByMsgId(Integer id);
}
