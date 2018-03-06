package com.ncuhome.startmeet.view;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO<T> implements Serializable{
    private Integer code;
    private String message;

    private T data;

    public ResultVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString(){
        if (data == null){
            return String.format("{\"code\":%d,\"message\":\"%s\"}",code,message);
        }else {
            return String.format("{\"code\":%d,\"message\":\"%s\",\"data\":%s}",code,message,data.toString());
        }
    }
}
