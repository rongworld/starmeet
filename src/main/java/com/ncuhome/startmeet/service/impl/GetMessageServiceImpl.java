package com.ncuhome.startmeet.service.impl;

import com.google.inject.Inject;
import com.ncuhome.startmeet.dao.MessageDao;
import com.ncuhome.startmeet.domain.Message;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.service.GetMessageService;
import com.ncuhome.startmeet.view.MessageVO;

import java.util.List;
import java.util.stream.Collectors;

public class GetMessageServiceImpl implements GetMessageService{

    @Inject
    private MessageDao messageDao;


    @Inject
    private User user;


    @Override
    public List<MessageVO> getMessages() {
        List<Message> messages = messageDao.findByUserId(user.getId());

        if (messages == null||messages.isEmpty()){
            return null;
        }

        return messages.stream().map(e->{

            MessageVO messageVO = new MessageVO();
            messageVO.setChatAvatar(e.getAvtar());
            messageVO.setDate(e.getDate());
            messageVO.setType(e.getType());
            messageVO.setChatStarname(e.getStarname());
            return messageVO;
        }).collect(Collectors.toList());
    }
}
