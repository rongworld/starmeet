package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.exception.Exp;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

/*点击星星操作
* */
public interface TouchStarService {
    //摘取星星
    void pick(Integer chatId) throws Exp;

    //放弃星星
    void abandon() throws Exp;
}
