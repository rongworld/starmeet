package com.ncuhome.startmeet.view;

import lombok.Data;

@Data
public class StarInfo {

    private Integer startId;

    private String label;

    private String gender;

    private String avatar;

    private String starname;

    private String starword;

    private final String text = "{\"startId\":%d,\"label\":\"%s\",\"gender\":\"%s\",\"avatar\":\"%s\",\"startname\":\"%s\"}";

    @Override
    public String toString(){
        return String.format(text,startId,label,gender,avatar,starname);
    }

}
