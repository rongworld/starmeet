package com.ncuhome.startmeet.dao;

import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.enums.StarStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
            user.setUserid("5555555" + i);
            user.setUsername("星"+i);
            user.setAvatar("http://star-avatar.oss-cn-beijing.aliyuncs.com/timg.jpg");
            user.setStarStatus(StarStatus.ABANDON.name());
            user.setLabel("[{'status': True, 'bqname': '汪星人'}, {'status': True, 'bqname': '长腿欧巴'}]");

            if (i % 2 == 0) {
                user.setGender("男");

            } else {
                user.setGender("女");
            }

            userDao.save(user);

        }


    }

    @Test
    public void getChatId() {

        User user = userDao.findUserById(1);

        System.out.println(user.toString());

    }


    @Test
    public void update() {
        List<User> users = userDao.findAll();
        users.forEach(e -> {
            e.setUserid(e.getStarname());
            userDao.saveAndFlush(e);
        });
    }
}