package com.cskaoyan.wdjava.vue.mapper;

import com.cskaoyan.wdjava.vue.bean.Ask;
import com.cskaoyan.wdjava.vue.bean.User;


public interface AskMapper {

    User getUserIdByNickName(String nickname);

    void insertAskMsg(Ask ask);
}
