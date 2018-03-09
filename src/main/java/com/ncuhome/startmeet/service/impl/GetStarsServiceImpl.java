package com.ncuhome.startmeet.service.impl;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.service.GetStarsService;
import com.ncuhome.startmeet.view.StarInfoVO;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class GetStarsServiceImpl implements GetStarsService {

    @Inject
    private UserDao userDao;

    @Inject
    private User user;

    @Override
    public List<StarInfoVO> getStarts() {
        List<User> users = userDao.findStarts(user.getId());
        return users.stream().map(
                 e->{
                     StarInfoVO starInfoVO = new StarInfoVO();
                     starInfoVO.setAvatar(e.getAvatar());
                     starInfoVO.setGender(e.getGender());
                     starInfoVO.setLabel(e.getLabel());
                     starInfoVO.setStarname(e.getStarname());
                     starInfoVO.setStartId(e.getId());
                     return starInfoVO;
                 }
         ).collect(Collectors.toList());
    }
}
