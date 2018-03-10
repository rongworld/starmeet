package com.ncuhome.startmeet.service.impl;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.Message;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.enums.Error;
import com.ncuhome.startmeet.enums.StarStatus;
import com.ncuhome.startmeet.enums.Type;
import com.ncuhome.startmeet.exception.Exp;
import com.ncuhome.startmeet.service.SaveMessageService;
import com.ncuhome.startmeet.service.TouchStarService;
import com.ncuhome.startmeet.util.CheckTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Slf4j
@RequestScoped
public class TouchStarServiceServiceImpl implements TouchStarService {

    @Inject
    private UserDao userDao;

    @Inject
    private User user;

    @Inject
    private SaveMessageService saveMessageService;

    @Override
    @Transactional
    public void pick(Integer chatId) throws Exp {

        User chatUser = userDao.findUserById(chatId);
        String status = user.getStarStatus();

        if (user == null) {
            throw new Exp(Error.No_User.name());
        }

        if (status.equals(StarStatus.PICKED.name())) {
            throw new Exp(Error.Has_Picked.name());
        }

        if (status.equals(StarStatus.PICKING.name())) {
            throw new Exp(Error.Has_Picking.name());
        }

        if (!chatUser.getStarStatus().equals(StarStatus.ABANDON.name())) {
            throw new Exp(Error.Picked.name());
        }


        if (!CheckTime.isBelong(user.getLastChangeTime())) {
            throw new Exp(Error.Illegal_Time.name());
        }


        if (CheckTime.isToday(user.getLastChangeTime(),new Date())) {
            throw new Exp(Error.No_Chance.name());
        }

        if (user.getId().equals(chatId)){
            throw new Exp(Error.NO_SELF.name());
        }

        user.setChatId(chatId);
        chatUser.setChatId(user.getId());
        chatUser.setStarStatus(StarStatus.PICKED.name());
        user.setStarStatus(StarStatus.PICKING.name());

        Date date = new Date();

        user.setLastChangeTime(date);
        chatUser.setLastChangeTime(date);
     //   saveMessageService.save(new Message(user.getId(),chatUser.getId(),date, Type.PICKING.name(),chatUser.getStarname(),chatUser.getAvatar(),0));
        saveMessageService.save(new Message(chatUser.getId(),user.getId(),date, Type.PICKED.name(),user.getStarname(),user.getAvatar(),0));

        userDao.saveAndFlush(user);
        userDao.saveAndFlush(chatUser);

    }

    @Override
    @Transactional
    public void abandon() throws Exp {
        if (user.getStarStatus().equals(StarStatus.ABANDON.name())) {
            throw new Exp(Error.Has_Abandon.name());
        }
        if (user.getChatId() == null) {
            throw new Exp(Error.No_Picked.name());
        }
        user.setStarStatus(StarStatus.ABANDON.name());
        User chatUser = userDao.findUserById(user.getChatId());
        chatUser.setStarStatus(StarStatus.ABANDON.name());
        saveMessageService.save(new Message(chatUser.getId(),chatUser.getId(),new Date(), Type.ABANDON.name(),chatUser.getStarname(),chatUser.getAvatar(),0));
        userDao.saveAndFlush(user);
        userDao.saveAndFlush(chatUser);
    }
}
