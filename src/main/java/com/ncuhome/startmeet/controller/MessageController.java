package com.ncuhome.startmeet.controller;

import com.ncuhome.startmeet.service.GetMessageService;
import com.ncuhome.startmeet.view.MessageVO;
import com.ncuhome.startmeet.view.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@RestController
@SessionScope
public class MessageController {

    @Autowired
    private GetMessageService getMessageService;
    @GetMapping(value = "/api/message")
    public String getMessage(){
        List<MessageVO> list = getMessageService.getMessages();
        return new ResultVO<>(0,"successful",list).toString();
    }
}
