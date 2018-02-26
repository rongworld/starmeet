package com.ncuhome.startmeet.controller;


import com.ncuhome.startmeet.enums.Error;
import com.ncuhome.startmeet.exception.Exp;
import com.ncuhome.startmeet.service.GetStarInfoService;
import com.ncuhome.startmeet.service.GetStarsService;
import com.ncuhome.startmeet.service.PublishService;
import com.ncuhome.startmeet.service.TouchStarService;
import com.ncuhome.startmeet.view.Result;
import com.ncuhome.startmeet.view.StarInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;


@RestController
@SessionScope
public class StarController {

    @Autowired
    private GetStarsService getStarsService;

    @Autowired
    private GetStarInfoService getStarInfoService;

    @Autowired
    private PublishService publishService;


    @Autowired
    private TouchStarService touchStarService;

    @GetMapping(value = "/api/stars")
    public String getStarts() {
        List<StarInfo> list = getStarsService.getStarts();
        return new Result<List>(0, "successful", list).toString();
    }

    @PostMapping(value = "/api/star")
    public String star(@RequestParam(name = "starId",required = false,defaultValue = "-1") Integer chatId) throws Exp {

        if (chatId == -1){
            return new Result(Error.Bad_Param.getCode(), "非法参数").toString();
        }

        touchStarService.pick(chatId);
        return new Result(0, "successful").toString();
    }

    @PostMapping(value = "/api/abandon")
    public String abandon() throws Exp {
        touchStarService.abandon();
        return new Result(0, "successful").toString();
    }

    @PostMapping(value = "/api/publish")
    public String publish(@RequestBody String body) {
        publishService.publish(body);
        return new Result(0, "successful").toString();
    }

    @GetMapping(value = "/api/star")
    public String getInfo() throws Exp {
        StarInfo starInfo = getStarInfoService.getStarInfo();
        return new Result<>(0, "successful", starInfo).toString();
    }


}
