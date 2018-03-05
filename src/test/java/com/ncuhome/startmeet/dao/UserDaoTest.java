package com.ncuhome.startmeet.dao;

import com.ncuhome.startmeet.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;


    @Test
    public void insert() {
        for (int i = 0; i <= 15; i++) {


            User user = new User();


            user.setStarword("starword" + i);
            user.setStarname("star" + i);
            user.setUsername("5555555" + i);

            user.setAvatar("http://io.myhoster.top/hua.jpg");

            user.setLabel("a|a|a");
            user.setGender("男");
            userDao.save(user);

        }


    }

    @Test
    public void getChatId() {

        User user = userDao.findUserById(1);

        System.out.println(user.toString());

    }


}