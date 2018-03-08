package com.ncuhome.startmeet.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.ServletModule;
import com.ncuhome.startmeet.dao.MessageDao;
import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.module.GuiceModule;
import com.ncuhome.startmeet.security.UserProvider;
import com.ncuhome.startmeet.service.*;
import com.ncuhome.startmeet.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;


/*
* 配置Controller层的Bean，对Service注入实现类，实现类由Guice管理
* */

@Configuration
public class BeanConfig {

    private final UserDao userDao;
    private final MessageDao messageDao;

    @Autowired
    public BeanConfig(UserDao userDao, MessageDao messageDao) {
        this.userDao = userDao;
        this.messageDao = messageDao;
    }


    @Bean
    public Injector getInjector() {
        return Guice.createInjector(
                new ServletModule(),
                binder -> binder.bind(UserDao.class).toInstance(userDao)
                , new GuiceModule()
                , binder -> binder.bind(MessageDao.class).toInstance(messageDao),
                binder -> binder.bind(User.class).toProvider(new UserProvider())
        );
    }


    @Bean
    @RequestScope
    public GetStarsService getStarsService(Injector injector) {
        return injector.getInstance(GetStarsServiceImpl.class);
    }

    @Bean
    @RequestScope
    public TouchStarService getTouchStar(Injector injector) {
        return injector.getInstance(TouchStarServiceServiceImpl.class);
    }


    @Bean
    @RequestScope
    public GetStarInfoService getStarInfoService(Injector injector) {
        return injector.getInstance(GetStarInfoServiceImpl.class);
    }

    @Bean
    @RequestScope
    public PublishService publishService(Injector injector) {
        return injector.getInstance(PublishServiceImpl.class);
    }


    @Bean
    @RequestScope
    public RankChartService rankChartService(Injector injector) {
        return injector.getInstance(RankChartServiceImpl.class);
    }

    @Bean
    @RequestScope
    public GetMessageService getMessageService(Injector injector) {
        return injector.getInstance(GetMessageServiceImpl.class);
    }

    @Bean
    @RequestScope
    public GetChatInfoService getChatInfoService(Injector injector) {
        return injector.getInstance(GetChatInfoServiceImpl.class);
    }
}
