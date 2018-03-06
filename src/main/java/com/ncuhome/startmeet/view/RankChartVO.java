package com.ncuhome.startmeet.view;

import lombok.Data;

@Data
public class RankChartVO {
    private String starname1;
    private String starname2;
    private String avatar1;
    private String avatar2;
    private Integer days;
    private final String text = "{\"starname1\":\"%s\",\"starname2\":\"%s\",\"avatar1\":\"%s\",\"avatar2\":\"%s\",\"days\":%d}";

    @Override
    public String toString() {
        return String.format(text, starname1, starname2, avatar1, avatar2, days);
    }


}
