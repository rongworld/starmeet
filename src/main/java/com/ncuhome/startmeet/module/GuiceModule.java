package com.ncuhome.startmeet.module;

import com.google.inject.AbstractModule;
import com.ncuhome.startmeet.service.*;
import com.ncuhome.startmeet.service.impl.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class GuiceModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(GetStarsService.class).to(GetStarsServiceImpl.class);
        bind(TouchStarService.class).to(TouchStarServiceServiceImpl.class);
        bind(PublishService.class).to(PublishServiceImpl.class);
        bind(GetStarInfoService.class).to(GetStarInfoServiceImpl.class);
        bind(RankChartService.class).to(RankChartServiceImpl.class);
    }

}
