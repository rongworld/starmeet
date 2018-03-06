package com.ncuhome.startmeet.service.impl;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.service.PublishService;
import org.springframework.transaction.annotation.Transactional;

@RequestScoped
public class PublishServiceImpl implements PublishService{

    @Inject
    private User user;

    @Inject
    private UserDao userDao;

    @Override
    @Transactional
    public void publish(String text) {
        user.setStarword(text);
        userDao.saveAndFlush(user);
    }

}
