package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.view.StarInfoVO;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

/*
* 获取星星
* */
public interface GetStarsService {
    List<StarInfoVO> getStarts();
}
