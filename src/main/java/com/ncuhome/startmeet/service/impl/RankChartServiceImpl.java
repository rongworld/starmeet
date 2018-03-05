package com.ncuhome.startmeet.service.impl;

import com.google.inject.Inject;
import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.enums.StarStatus;
import com.ncuhome.startmeet.service.RankChartService;
import com.ncuhome.startmeet.view.RankChart;

import java.util.List;
import java.util.stream.Collectors;

public class RankChartServiceImpl implements RankChartService{

    @Inject
    private UserDao userDao;

    @Override
    public List<RankChart> getRankChart() {
        List<User> list = userDao.findTop10ByStarStatusEqualsOrderByLastChangeTimeAsc(StarStatus.PICKING.name());

        if (list == null||list.isEmpty()){
            return null;
        }


        return list.stream().map(e->{
            RankChart rankChart = new RankChart();
            User chatUser = userDao.findUserById(e.getChatId());
            rankChart.setAvatar1(e.getAvatar());
            rankChart.setAvatar2(chatUser.getAvatar());
            rankChart.setStarname1(e.getStarname());
            rankChart.setStarname2(chatUser.getStarname());
            rankChart.setDays((int) ((System.currentTimeMillis()-e.getLastChangeTime().getTime())/(1000*60*60*24)));
            return rankChart;
        }).collect(Collectors.toList());
    }
}
