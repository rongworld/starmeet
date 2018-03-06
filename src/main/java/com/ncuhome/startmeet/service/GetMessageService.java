package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.view.MessageVO;

import java.util.List;

public interface GetMessageService{
    List<MessageVO> getMessages();
    Integer getNotReadMessageNumber();
}
