package com.cskaoyan.wdjava.admin.service;


import com.cskaoyan.wdjava.admin.bean.AdminReply;
import com.cskaoyan.wdjava.admin.vo.AdminSelectReq;
import com.cskaoyan.wdjava.base.BaseRes;

public interface AdminMsgService {

    public BaseRes noReplyMsg() throws Exception;

    public BaseRes repliedMsg() throws Exception;

    public BaseRes reply(AdminReply adminReply) throws Exception;
}
