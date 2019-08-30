package com.cskaoyan.wdjava.vue.service.impl;

import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.bean.*;
import com.cskaoyan.wdjava.vue.mapper.GoodMapper;
import com.cskaoyan.wdjava.vue.service.GoodService;
import com.cskaoyan.wdjava.vue.vo.GoodReq;
import com.cskaoyan.wdjava.vue.vo.GoodRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    GoodMapper goodMapper;


    @Override
    public BaseRes getGoodsByType(GoodReq goodReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer typeId = goodReq.getTypeId();

        List<GoodRes> list = goodMapper.getGoodsByType(typeId);

        baseRes.setCode(0);
        baseRes.setData(list);
        return baseRes;
    }

    @Override
    public BaseRes getGoodsInfo(GoodReq goodReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = goodReq.getId();

        Good good = goodMapper.getGoodsInfoById(id);
        List<Specs> listSpecs = goodMapper.selectSpecsById(id);
        good.setSpecs(listSpecs);

        baseRes.setCode(0);
        baseRes.setData(good);
        return baseRes;
    }

    @Override
    public BaseRes getGoodsMsg(GoodReq goodReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = goodReq.getId();

        List<Messages> list = goodMapper.getGoodsMsg(id);
        for (Messages messages : list) {
            Integer msgId = messages.getId();
            Reply reply = goodMapper.getReplyByMsgId(msgId);
            if (reply == null){
                reply = new Reply();
            }
            messages.setReply(reply);
        }

        baseRes.setCode(0);
        baseRes.setData(list);
        return baseRes;
    }

    @Override
    public BaseRes getGoodsComment(GoodReq goodReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer goodsId = goodReq.getGoodsId();
        Float rate = 0.0f;

        List<Comment> commentList = goodMapper.getGoodsComment(goodsId);
        for (Comment comment : commentList) {
            if (comment.getScore()> 80){
                rate = rate + 1;
            }
            Integer userId = comment.getUserId();
            User user = goodMapper.selectUserBy(userId);
            comment.setUser(user);
        }

        HashMap<Object, Object> map = new HashMap<>();
        map.put("commentList",commentList);
        map.put("rate",rate/commentList.size()*100);
        baseRes.setCode(0);
        baseRes.setData(map);
        return baseRes;
    }
}
