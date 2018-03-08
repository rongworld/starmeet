package com.ncuhome.startmeet.service;

import com.ncuhome.startmeet.view.RankChartVO;

import java.util.List;


/*
* 获取排行榜
* */
public interface RankChartService {
    List<RankChartVO> getRankChart();
}
