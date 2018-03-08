package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.exception.Exp;
import com.ncuhome.startmeet.view.ChatInfoVO;

/*
* 加载聊天资料
* */
public interface GetChatInfoService {
    ChatInfoVO getInfo() throws Exp;
}
