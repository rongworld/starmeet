package com.ncuhome.startmeet.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private Integer chatId;
    private Date date;
    private String type;
    private String starname;
    private String avtar;
    private Integer status;

    public Message() {

    }

    public Message(Integer userId, Integer chatId, Date date, String type, String starname, String avtar,Integer status) {
        this.userId = userId;
        this.chatId = chatId;
        this.date = date;
        this.type = type;
        this.starname = starname;
        this.avtar = avtar;
        this.status = status;
    }
}
