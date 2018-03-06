package com.ncuhome.startmeet.exception;

import com.ncuhome.startmeet.enums.Error;
import com.ncuhome.startmeet.view.ResultVO;
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
                return new ResultVO(Error.No_Chance.getCode(), "今天没有机会了").toString();

            case Has_Picked:
                return new ResultVO(Error.Has_Picked.getCode(), "你已经被守护了").toString();

            case Has_Picking:
                return new ResultVO(Error.Has_Picking.getCode(), "你正在守护别人").toString();

            case Illegal_Time:
                return new ResultVO(Error.Illegal_Time.getCode(), "还没到时间哦").toString();

            case Picked:
                return new ResultVO(Error.Picked.getCode(), "此人刚被守护了").toString();

            case Permission_Denied:
                return new ResultVO(Error.Permission_Denied.getCode(), "没有权限").toString();

            case Unknown_Error:
                return new ResultVO(Error.Unknown_Error.getCode(), "未知错误").toString();

            case No_User:
                return new ResultVO(Error.No_User.getCode(), "用户不存在").toString();

            case Bad_Param:
                return new ResultVO(Error.Bad_Param.getCode(), "错误参数").toString();

            case Has_Abandon:
                return new ResultVO(Error.Has_Abandon.getCode(), "已经放弃了").toString();

            case No_Picked:
                return new ResultVO(Error.No_Picked.getCode(), "未被守护").toString();


        }
        return new ResultVO(Error.Unknown_Error.getCode(), "未知错误").toString();

    }

}
