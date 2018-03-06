package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.exception.Exp;
import com.ncuhome.startmeet.view.StarInfoVO;

public interface GetStarInfoService {
    StarInfoVO getStarInfo() throws Exp;
}
