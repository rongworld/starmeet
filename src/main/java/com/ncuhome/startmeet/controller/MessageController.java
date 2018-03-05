package com.ncuhome.startmeet.controller;

import com.ncuhome.startmeet.service.GetMessageService;
import com.ncuhome.startmeet.view.MessageVO;
import com.ncuhome.startmeet.view.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private GetMessageService getMessageService;
    @GetMapping(value = "/api/message")
    public String getMessage(){
        List<MessageVO> list = getMessageService.getMessages();
        return new Result<>(0,"successful",list).toString();
    }
}
