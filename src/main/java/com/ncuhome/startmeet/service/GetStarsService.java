package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.view.StarInfo;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@SessionScope
public interface GetStarsService {
    List<StarInfo> getStarts();
}
