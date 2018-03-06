package com.ncuhome.startmeet.service.impl;

import com.google.inject.Inject;
import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.enums.Error;
import com.ncuhome.startmeet.enums.StarStatus;
import com.ncuhome.startmeet.exception.Exp;
import com.ncuhome.startmeet.service.GetStarInfoService;
import com.ncuhome.startmeet.view.StarInfoVO;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class GetStarInfoServiceImpl implements GetStarInfoService {

    @Inject
    private UserDao userDao;

    @Inject
    private User user;

    @Override
    public StarInfoVO getStarInfo() throws Exp {
        if (user.getStarStatus().equals(StarStatus.ABANDON.name())){
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
        return starInfoVO;
    }
}
