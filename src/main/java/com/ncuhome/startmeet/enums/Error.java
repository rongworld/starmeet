package com.ncuhome.startmeet.enums;

public enum  Error {
    Permission_Denied(-1),
    Illegal_Time(1),//非法时间
    Picked(2),//此人已被守护
    Has_Picking(3),//正在守护
    Has_Picked(4),//正被守护
    No_Chance(5),//没有机会
    Unknown_Error(6),//未知错误
    No_User(7),//用户未找到
    Bad_Param(8),//非法参数
    Has_Abandon(9),//已经放弃
    No_Picked(10),//未被守护
    ;


    Error(Integer i){
        code = i;
    }
    private Integer code;

    public Integer getCode(){
        return code;
    }

}
