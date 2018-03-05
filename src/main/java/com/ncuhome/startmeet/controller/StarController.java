package com.ncuhome.startmeet.controller;




import com.ncuhome.startmeet.dao.UserDao;
import com.ncuhome.startmeet.domain.User;
import com.ncuhome.startmeet.enums.Error;
import com.ncuhome.startmeet.enums.StarStatus;
import com.ncuhome.startmeet.exception.Exp;
import com.ncuhome.startmeet.security.Token;
import com.ncuhome.startmeet.security.UserProvider;
import com.ncuhome.startmeet.service.*;
import com.ncuhome.startmeet.view.RankChart;
import com.ncuhome.startmeet.view.Result;
import com.ncuhome.startmeet.view.StarInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@SessionScope
@Slf4j
public class StarController {


    @Autowired
    private GetStarsService getStarsService;

    @Autowired
    private GetStarInfoService getStarInfoService;

    @Autowired
    private PublishService publishService;


    @Autowired
    private TouchStarService touchStarService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RankChartService rankChartService;

    @GetMapping(value = "/api/stars")
    public String getStarts() {
        List<StarInfo> list = getStarsService.getStarts();
        String userId = (String) Token.getInfo(httpServletRequest.getHeader("Authorization"),"userID");
       User user = userDao.findUserById(Integer.valueOf(userId));
       switch (StarStatus.valueOf(user.getStarStatus())){
           case ABANDON:
               return new Result<List>(0, "successful", list).toString();
           case PICKED:
               return new Result<List>(Error.Has_Picked.getCode(), Error.Has_Picked.name(), list).toString();
           case PICKING:
               return new Result<List>(Error.Has_Picking.getCode(), Error.Has_Picking.name(), list).toString();

       }


        return new Result<List>(0, "successful", list).toString();
    }

    @PostMapping(value = "/api/star")
    public String star(@RequestParam(name = "chatID",required = false,defaultValue = "-1") Integer chatId) throws Exp {

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


    @GetMapping(value = "/api/rankChart")

    public String getRankChart(){
        List<RankChart> list = rankChartService.getRankChart();
        return new Result<>(0,"successful",list).toString();
    }

}
