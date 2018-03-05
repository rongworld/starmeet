package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.domain.Message;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


@Service
@SessionScope
public interface SaveMessageService {
    void save(Message message);
}
