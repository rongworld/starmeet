package com.ncuhome.startmeet.service.impl;

import com.google.inject.Inject;
import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.enums.Error;
import com.ncuhome.startmeet.enums.StarStatus;
import com.ncuhome.startmeet.exception.Exp;
import com.ncuhome.startmeet.service.GetStarInfoService;
import com.ncuhome.startmeet.view.StarInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class GetStarInfoServiceImpl implements GetStarInfoService {

    @Inject
    private UserDao userDao;

    @Inject
    private User user;

    @Override
    public StarInfo getStarInfo() throws Exp {
        if (user.getStarStatus().equals(StarStatus.ABANDON.name())){
            throw new Exp(Error.No_Picked.name());
        }
        User chatUser = userDao.findUserById(user.getChatId());
        if (chatUser == null) {
            return null;
        }
        StarInfo starInfo = new StarInfo();
        starInfo.setStarname(chatUser.getStarname());
        starInfo.setStartId(chatUser.getId());
        starInfo.setLabel(chatUser.getLabel());
        starInfo.setGender(chatUser.getGender());
        starInfo.setStarword(chatUser.getStarword());
        return starInfo;
    }
}
