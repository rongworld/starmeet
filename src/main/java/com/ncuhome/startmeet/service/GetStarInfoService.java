package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.exception.Exp;
import com.ncuhome.startmeet.view.StarInfo;

public interface GetStarInfoService {
    StarInfo getStarInfo() throws Exp;
}
