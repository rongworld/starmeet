package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.view.MessageVO;

import java.util.List;

/*
* 获取通知
* */
public interface GetMessageService{
    //获取每条消息
    List<MessageVO> getMessages();

    //获取未读消息数目
    Integer getNotReadMessageNumber();
}
