package com.ncuhome.startmeet.domain;


import com.ncuhome.startmeet.enums.StarStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@ToString
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 1023, name = "avatar")
    private String avatar;

    @Column(length = 15, name = "username")
    private String username;

    @Column(length = 63, name = "starname")
    private String starname;

    @Column(length = 7, name = "gender")
    private String gender;

    @Column(length = 511,name = "label")
    private String label;

    @Column(length = 511, name = "starword")
    private String starword;

    @Column(length = 1023, name = "history")
    private String history;

    @Column(length = 15, name = "likability")
    private Float likability;

    @Column(length = 31, name = "chatID")
    private Integer chatId;

    @Column(length = 31, name = "star_status")
    private String starStatus = StarStatus.ABANDON.name();

    @Column(length = 31, name = "last_change_time")
    private Date lastChangeTime;

    @Column(length = 63, name = "userid",unique = true)
    private String userid;

    @Column(length = 63, name = "login_time")
    private String loginTime;
}
