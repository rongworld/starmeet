package com.ncuhome.startmeet.service.impl;

import com.google.inject.Inject;
import com.ncuhome.startmeet.dao.MessageDao;
import com.ncuhome.startmeet.domain.Message;
import com.ncuhome.startmeet.service.SaveMessageService;

public class SaveMessageServiceImpl implements SaveMessageService{
   @Inject
   private MessageDao messageDao;
    @Override
    public void save(Message message) {
        messageDao.saveAndFlush(message);
    }
}
