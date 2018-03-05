package com.ncuhome.startmeet.config;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.module.GuiceModule;
import com.ncuhome.startmeet.security.UserProvider;
import com.ncuhome.startmeet.service.*;
import com.ncuhome.startmeet.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import javax.servlet.http.HttpServletRequest;

@Configuration
public class BeanConfig {

    private final HttpServletRequest httpServletRequest;//把request传给guice
    private final UserDao userDao;

    @Autowired
    public BeanConfig(HttpServletRequest httpServletRequest, UserDao userDao) {
        this.httpServletRequest = httpServletRequest;
        this.userDao = userDao;
    }


    @Bean
    public Injector getInjector() {
        return Guice.createInjector(
                binder -> binder.bind(HttpServletRequest.class)
                        .toInstance(httpServletRequest)
                , binder -> binder.bind(UserDao.class).toInstance(userDao)
                , new GuiceModule(),
                binder -> binder.bind(User.class).toProvider(new UserProvider())
        );
    }


    @Bean
    @SessionScope
    public GetStarsService getStarsService(Injector injector) {
        return injector.getInstance(GetStarsServiceImpl.class);
    }

    @Bean
    @SessionScope
    public TouchStarService getTouchStar(Injector injector) {
        return injector.getInstance(TouchStarServiceServiceImpl.class);
    }


    @Bean
    @SessionScope
    public GetStarInfoService getStarInfoService(Injector injector){
        return injector.getInstance(GetStarInfoServiceImpl.class);
    }

    @Bean
    @SessionScope
    public PublishService publishService(Injector injector){
        return injector.getInstance(PublishServiceImpl.class);
    }


    @Bean
    @SessionScope
    public RankChartService rankChartService(Injector injector) {
        return injector.getInstance(RankChartServiceImpl.class);
    }

}
