package com.ncuhome.startmeet.view;

import lombok.Data;

@Data
public class ChatInfoVO {
    private String avatar1;

    private String avatar2;

    private String starname1;

    private String starname2;

    private Integer days;

    private final String text = "{\"avatar1\":\"%s\",\"avatar2\":\"%s\",\"starname1\":\"%s\",\"starname2\":\"%s\",\"days\":%d}";



    @Override
    public String toString(){
        return String.format(text,avatar1,avatar2,starname1,starname2,days);
    }
}
