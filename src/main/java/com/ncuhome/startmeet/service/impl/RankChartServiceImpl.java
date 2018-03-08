package com.ncuhome.startmeet.service.impl;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.enums.StarStatus;
import com.ncuhome.startmeet.service.RankChartService;
import com.ncuhome.startmeet.view.RankChartVO;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class RankChartServiceImpl implements RankChartService{

    @Inject
    private UserDao userDao;

    @Override
    public List<RankChartVO> getRankChart() {
        List<User> list = userDao.findTop10ByStarStatusEqualsOrderByLastChangeTimeAsc(StarStatus.PICKING.name());

        if (list == null||list.isEmpty()){
            return null;
        }


        return list.stream().filter(e->e.getLastChangeTime() != null&&e.getChatId()!=null).map(e->{
            RankChartVO rankChartVO = new RankChartVO();
            User chatUser = userDao.findUserById(e.getChatId());
            rankChartVO.setAvatar1(e.getAvatar());
            rankChartVO.setAvatar2(chatUser.getAvatar());
            rankChartVO.setStarname1(e.getStarname());
            rankChartVO.setStarname2(chatUser.getStarname());
            rankChartVO.setDays((int) ((System.currentTimeMillis()-e.getLastChangeTime().getTime())/(1000*60*60*24)));
            return rankChartVO;
        }).collect(Collectors.toList());
    }
}
