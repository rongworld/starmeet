package com.ncuhome.startmeet.domain;

import lombok.Data;

import javax.persistence.Column;
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

    @Column(length = 63,name = "user_id")
    private Integer userId;

    @Column(length = 63,name = "chat_id")
    private Integer chatId;

    @Column(length = 63,name = "date")
    private Date date;

    @Column(length = 31,name = "type")
    private String type;

    @Column(length = 63, name = "starname")
    private String starname;

    @Column(length = 1023,name = "avatar")
    private String avatar;

    @Column(length = 7,name = "status")
    private Integer status;

    public Message(){}
    public Message(Integer userId, Integer chatId, Date date, String type, String starname, String avatar, Integer status) {
        this.userId = userId;
        this.chatId = chatId;
        this.date = date;
        this.type = type;
        this.starname = starname;
        this.avatar = avatar;
        this.status = status;
    }
}
