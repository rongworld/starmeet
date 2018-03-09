package com.ncuhome.startmeet.service.impl;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.enums.Error;
import com.ncuhome.startmeet.enums.StarStatus;
import com.ncuhome.startmeet.exception.Exp;
import com.ncuhome.startmeet.service.GetStarInfoService;
import com.ncuhome.startmeet.view.StarInfoVO;

import java.text.SimpleDateFormat;

@RequestScoped
public class GetStarInfoServiceImpl implements GetStarInfoService {

    @Inject
    private UserDao userDao;

    @Inject
    private User user;

    @Override
    public StarInfoVO getStarInfo() throws Exp {
        if (user.getStarStatus().equals(StarStatus.ABANDON.name())) {
            throw new Exp(Error.No_Picked.name());
        }
        User chatUser = userDao.findUserById(user.getChatId());
        if (chatUser == null) {
            return null;
        }
        StarInfoVO starInfoVO = new StarInfoVO();
        starInfoVO.setStarname(chatUser.getStarname());
        starInfoVO.setStartId(chatUser.getId());
        starInfoVO.setLabel(chatUser.getLabel());
        starInfoVO.setGender(chatUser.getGender());
        starInfoVO.setStarword(chatUser.getStarword());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日 HH:mm");

        starInfoVO.setDate(simpleDateFormat.format(user.getLastChangeTime()));
        starInfoVO.setDays((int) ((System.currentTimeMillis() - user.getLastChangeTime().getTime()) / (1000 * 60 * 60 * 24)));
        return starInfoVO;
    }
}
