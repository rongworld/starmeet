package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.view.StarInfoVO;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;


public interface GetStarsService {
    List<StarInfoVO> getStarts();
}
