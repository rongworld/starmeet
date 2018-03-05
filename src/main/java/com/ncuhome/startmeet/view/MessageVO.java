package com.ncuhome.startmeet.view;

import lombok.Data;

import java.util.Date;

@Data
public class MessageVO {
    private String chatStarname;

    private String type;

    private Date date;

    private String chatAvatar;

    private final String text = "{\"chatStarname\":\"%s\",\"type\":\"%s\",\"date\":\"%s\",\"chatAvatar\":\"%s\"}";

    @Override
    public String toString(){
        return String.format(text,chatStarname,type,date,chatAvatar);
    }

}
