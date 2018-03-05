package com.ncuhome.startmeet.domain;


import com.ncuhome.startmeet.enums.StarStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@ToString
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String avatar;

    private String username;

    private String starname;

    private String gender;

    private String label;

    private String starword;

    private String history;

    private Float likability;

    private Integer chatId;

    private String starStatus = StarStatus.ABANDON.name();

    private Date lastChangeTime;

}
