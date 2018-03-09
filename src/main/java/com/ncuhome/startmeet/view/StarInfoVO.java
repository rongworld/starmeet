package com.ncuhome.startmeet.view;

import lombok.Data;

import java.util.Date;

@Data
public class StarInfoVO {

    private Integer startId;

    private String label;

    private String gender;

    private String avatar;

    private String starname;

    private String starword;

    private String date;

    private Integer days;

    private final String text = "{\"chatID\":%d,\"label\":%s,\"gender\":\"%s\",\"avatar\":\"%s\",\"starname\":\"%s\",\"date\":\"%s\",\"days\":%d}";

    @Override
    public String toString(){
        return String.format(text,startId,label,gender,avatar,starname,date,days);
    }

}
