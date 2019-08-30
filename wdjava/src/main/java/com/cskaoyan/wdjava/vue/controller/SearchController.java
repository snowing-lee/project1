package com.cskaoyan.wdjava.vue.controller;

import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.service.SearchService;
import com.cskaoyan.wdjava.vue.vo.SearchReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/good")
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/api/mall/searchGoods" , method = RequestMethod.GET)
    public BaseRes searchGoods(SearchReq searchReq){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = searchService.searchGoods(searchReq);
        }catch (Exception e) {
        }finally {
        }

       return baseRes;
    }
}
