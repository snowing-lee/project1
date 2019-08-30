package com.cskaoyan.wdjava.admin.service.impl;

import com.cskaoyan.wdjava.admin.bean.AdminAddGoods;
import com.cskaoyan.wdjava.admin.bean.AdminMsg;
import com.cskaoyan.wdjava.admin.bean.AdminReply;
import com.cskaoyan.wdjava.admin.bean.AdminUser;
import com.cskaoyan.wdjava.admin.mapper.AdminMsgMapper;
import com.cskaoyan.wdjava.admin.service.AdminMsgService;
import com.cskaoyan.wdjava.base.BaseRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminMsgServiceImpl implements AdminMsgService {

    @Autowired
    AdminMsgMapper adminMsgMapper;

    @Override
    public BaseRes noReplyMsg() throws Exception {
        BaseRes baseRes = new BaseRes();

        List<AdminMsg> list = adminMsgMapper.noReplyMsg();
        for (AdminMsg adminMsg : list) {
            Integer goodsId = adminMsg.getGoodsId();
            AdminAddGoods goods = adminMsgMapper.getGoodsByGoodsId(goodsId);
            adminMsg.setGoods(goods);

            Integer userId = adminMsg.getUserId();
            AdminUser user = adminMsgMapper.getUserByUserId(userId);
            adminMsg.setUser(user);

        }

        baseRes.setCode(0);
        baseRes.setData(list);
        return baseRes;
    }

    @Override
    public BaseRes repliedMsg() throws Exception {
        BaseRes baseRes = new BaseRes();

        List<AdminMsg> list = adminMsgMapper.repliedMsg();
        for (AdminMsg adminMsg : list) {
            Integer goodsId = adminMsg.getGoodsId();
            AdminAddGoods goods = adminMsgMapper.getGoodsByGoodsId(goodsId);
            adminMsg.setGoods(goods);

            Integer userId = adminMsg.getUserId();
            AdminUser user = adminMsgMapper.getUserByUserId(userId);
            adminMsg.setUser(user);

        }
        baseRes.setCode(0);
        baseRes.setData(list);
        return baseRes;
    }

    @Override
    public BaseRes reply(AdminReply adminReply) throws Exception {
        BaseRes baseRes = new BaseRes();

        adminMsgMapper.insertReply(adminReply);
        adminMsgMapper.updateStateByMsgId(adminReply.getId());

        baseRes.setCode(0);
        return baseRes;
    }
}
