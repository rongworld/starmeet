package com.ncuhome.startmeet.security;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class UserProvider implements Provider<User> {

    @Inject
    private Provider<HttpServletRequest> httpServletRequestProvider;

    @Inject
    private UserDao userDao;

    @Override
    public User get() {
        String token = httpServletRequestProvider.get().getHeader("Authorization");
        String userId = (String) Token.getInfo(token, "userID");
        return userDao.findUserById(Integer.valueOf(userId));
    }
}
