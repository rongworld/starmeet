package com.ncuhome.startmeet.service.impl;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import com.ncuhome.startmeet.dao.MessageDao;
import com.ncuhome.startmeet.domain.Message;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.service.GetMessageService;
import com.ncuhome.startmeet.view.MessageVO;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
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
            e.setStatus(1);
            MessageVO messageVO = new MessageVO();
            messageVO.setChatAvatar(e.getAvatar());
            messageVO.setDate(e.getDate());
            messageVO.setType(e.getType());
            messageVO.setChatStarname(e.getStarname());
            return messageVO;
        }).collect(Collectors.toList());
    }

    @Override
    public Integer getNotReadMessageNumber() {
        List<Message> messages = messageDao.findByUserId(user.getId());
        List list = messages.stream().filter(e->e.getStatus() == 0).collect(Collectors.toList());
        return list.size();
    }
}
