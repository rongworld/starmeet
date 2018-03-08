package com.ncuhome.startmeet.view;

import lombok.Data;

@Data
public class StarInfoVO {

    private Integer startId;

    private String label;

    private String gender;

    private String avatar;

    private String starname;

    private String starword;

    private final String text = "{\"chatID\":%d,\"label\":%s,\"gender\":\"%s\",\"avatar\":\"%s\",\"starname\":\"%s\"}";

    @Override
    public String toString(){
        return String.format(text,startId,label,gender,avatar,starname);
    }

}
