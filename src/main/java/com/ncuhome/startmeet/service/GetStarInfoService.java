package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.exception.Exp;
import com.ncuhome.startmeet.view.StarInfoVO;

/*
* 获取聊天对象资料
* */
public interface GetStarInfoService {
    StarInfoVO getStarInfo() throws Exp;
}
