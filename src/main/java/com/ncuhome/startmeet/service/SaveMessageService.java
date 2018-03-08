package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.domain.Message;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


/*
* 存储消息
* */
public interface SaveMessageService {
    void save(Message message);
}
