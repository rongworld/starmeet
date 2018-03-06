package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.exception.Exp;
import com.ncuhome.startmeet.view.ChatInfoVO;

public interface GetChatInfoService {
    ChatInfoVO getInfo() throws Exp;
}
