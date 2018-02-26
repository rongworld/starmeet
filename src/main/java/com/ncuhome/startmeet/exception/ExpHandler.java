package com.ncuhome.startmeet.exception;

import com.ncuhome.startmeet.enums.Error;
import com.ncuhome.startmeet.view.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//统一异常处理
@RestControllerAdvice(annotations = RestController.class)
public class ExpHandler {
    @ExceptionHandler(value = Exp.class)
    public String handler(Exception e) {
        switch (Error.valueOf(e.getMessage())) {
            case No_Chance:
                return new Result(Error.No_Chance.getCode(), "今天没有机会了").toString();

            case Has_Picked:
                return new Result(Error.Has_Picked.getCode(), "你已经被守护了").toString();

            case Has_Picking:
                return new Result(Error.Has_Picking.getCode(), "你正在守护别人").toString();

            case Illegal_Time:
                return new Result(Error.Illegal_Time.getCode(), "还没到时间哦").toString();

            case Picked:
                return new Result(Error.Picked.getCode(), "此人刚被守护了").toString();

            case Permission_Denied:
                return new Result(Error.Permission_Denied.getCode(), "没有权限").toString();

            case Unknown_Error:
                return new Result(Error.Unknown_Error.getCode(), "未知错误").toString();

            case No_User:
                return new Result(Error.No_User.getCode(), "用户不存在").toString();

            case Bad_Param:
                return new Result(Error.Bad_Param.getCode(), "错误参数").toString();

            case Has_Abandon:
                return new Result(Error.Has_Abandon.getCode(), "已经放弃了").toString();

            case No_Picked:
                return new Result(Error.No_Picked.getCode(), "未被守护").toString();


        }
        return new Result(Error.Unknown_Error.getCode(), "未知错误").toString();

    }

}
