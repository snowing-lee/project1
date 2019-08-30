package com.cskaoyan.wdjava.vue.service.impl;

import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.bean.Ask;
import com.cskaoyan.wdjava.vue.bean.User;
import com.cskaoyan.wdjava.vue.mapper.AskMapper;
import com.cskaoyan.wdjava.vue.service.AskService;
import com.cskaoyan.wdjava.vue.vo.AskReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AskServiceImpl implements AskService {

    @Autowired
    AskMapper askMapper;

    @Override
    public BaseRes askGoodsMsg(AskReq askReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        String token = askReq.getToken();
        String nickname = token;
        User user = askMapper.getUserIdByNickName(nickname);
        Integer userId = user.getId();

        Ask ask = new Ask();

        ask.setUserId(userId);
        ask.setGoodsId(Integer.parseInt(askReq.getGoodsId()));
        ask.setContent(askReq.getMsg());

        askMapper.insertAskMsg(ask);

        baseRes.setCode(0);
        return baseRes;
    }
}
