package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.exception.Exp;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public interface TouchStarService {
    void pick(Integer chatId) throws Exp;
    void abandon() throws Exp;
}
