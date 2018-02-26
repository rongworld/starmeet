package com.ncuhome.startmeet.service.impl;

import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.enums.StarStatus;
import com.ncuhome.startmeet.service.GetStarsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class GetStarsServiceImplTest {

    @Autowired
    private GetStarsService getStarsService;

    @Autowired
    private UserDao userDao;

    @Test
    public void getStarts() {
        User user = new User();
        user.setStarStatus(StarStatus.ABANDON.name());
        user.setStarname("444");
        userDao.saveAndFlush(user);

        List list = getStarsService.getStarts();
        log.info("----------------------------------log-----------------------------");
        log.info(list.toString());
    }
}