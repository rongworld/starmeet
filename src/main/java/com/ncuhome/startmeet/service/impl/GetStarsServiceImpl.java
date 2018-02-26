package com.ncuhome.startmeet.service.impl;

import com.google.inject.Inject;
import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.service.GetStarsService;
import com.ncuhome.startmeet.view.StarInfo;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.stream.Collectors;

@SessionScope
public class GetStarsServiceImpl implements GetStarsService {

    @Inject
    private UserDao userDao;

    @Override
    public List<StarInfo> getStarts() {
        List<User> users = userDao.findStarts();
        return users.stream().map(
                 e->{
                     StarInfo starInfo = new StarInfo();
                     starInfo.setAvatar(e.getAvatar());
                     starInfo.setGender(e.getGender());
                     starInfo.setLabel(e.getLabel());
                     starInfo.setStarname(e.getStarname());
                     starInfo.setStartId(e.getId());
                     return starInfo;
                 }
         ).collect(Collectors.toList());
    }
}
