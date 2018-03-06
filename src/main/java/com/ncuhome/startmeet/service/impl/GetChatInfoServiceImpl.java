package com.ncuhome.startmeet.service.impl;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.service.GetChatInfoService;
import com.ncuhome.startmeet.view.ChatInfoVO;

@RequestScoped
public class GetChatInfoServiceImpl implements GetChatInfoService{
    @Inject
    private User user;

    @Inject
    private UserDao userDao;

    @Override
    public ChatInfoVO getInfo() {
        ChatInfoVO chatInfoVO = new ChatInfoVO();
        User chatUser = userDao.findUserById(user.getChatId());
        chatInfoVO.setAvatar1(user.getAvatar());
        chatInfoVO.setAvatar2(chatUser.getAvatar());
        chatInfoVO.setStarname1(user.getStarname());
        chatInfoVO.setStarname2(chatUser.getStarname());
        chatInfoVO.setDays(5);
        return chatInfoVO;
    }
}
