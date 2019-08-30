package com.cskaoyan.wdjava.vue.mapper;

import com.cskaoyan.wdjava.vue.vo.GoodRes;

import java.util.List;

public interface SearchMapper {

    List<GoodRes> searchGoods(String keyword);
}
