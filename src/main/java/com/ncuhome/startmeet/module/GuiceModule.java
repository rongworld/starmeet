package com.ncuhome.startmeet.module;

import com.google.inject.AbstractModule;
import com.ncuhome.startmeet.service.GetStarInfoService;
import com.ncuhome.startmeet.service.GetStarsService;
import com.ncuhome.startmeet.service.PublishService;
import com.ncuhome.startmeet.service.TouchStarService;
import com.ncuhome.startmeet.service.impl.GetStarInfoServiceImpl;
import com.ncuhome.startmeet.service.impl.GetStarsServiceImpl;
import com.ncuhome.startmeet.service.impl.PublishServiceImpl;
import com.ncuhome.startmeet.service.impl.TouchStarServiceServiceImpl;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class GuiceModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(GetStarsService.class).to(GetStarsServiceImpl.class);
        bind(TouchStarService.class).to(TouchStarServiceServiceImpl.class);
        bind(PublishService.class).to(PublishServiceImpl.class);
        bind(GetStarInfoService.class).to(GetStarInfoServiceImpl.class);
    }

}
