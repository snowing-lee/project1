package com.cskaoyan.wdjava.admin.controller;

import com.cskaoyan.wdjava.admin.bean.AdminReply;
import com.cskaoyan.wdjava.admin.service.AdminMsgService;
import com.cskaoyan.wdjava.admin.service.AdminSelectService;
import com.cskaoyan.wdjava.admin.vo.AdminSelectReq;
import com.cskaoyan.wdjava.base.BaseRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminMsgController {

    @Autowired
    AdminMsgService adminMsgService;

    @RequestMapping(value = "/api/admin/noReplyMsg" , method = RequestMethod.GET)
    public BaseRes noReplyMsg(){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminMsgService.noReplyMsg();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }

       return baseRes;
    }


    @RequestMapping(value = "/api/admin/repliedMsg" , method = RequestMethod.GET)
    public BaseRes repliedMsg(){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminMsgService.repliedMsg();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }
        return baseRes;
    }



    @RequestMapping(value = "/api/admin/reply" , method = RequestMethod.POST)
    public BaseRes reply(@RequestBody AdminReply adminReply){
        BaseRes baseRes = new BaseRes();
        try{
            baseRes = adminMsgService.reply(adminReply);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {
        }
        return baseRes;
    }

}
