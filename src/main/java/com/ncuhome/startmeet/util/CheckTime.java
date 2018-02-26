package com.ncuhome.startmeet.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckTime {

    public static Boolean isBelong(Date date) {

        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//设置日期格式
        Date beginTime = null;
        Date endTime = null;
        try {
            date = df.parse(df.format(new Date()));
            beginTime = df.parse("19:00:00");
            endTime = df.parse("23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return belongCalendar(date, beginTime, endTime);
    }


    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return boolean
     */
    private static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        return nowTime.getTime() >= beginTime.getTime() && nowTime.getTime() <= endTime.getTime();
    }


    public static Boolean isToday(Date date) {

        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy:MM:dd");
        String nowStr = simpleDateFormat.format(now);
        String dateStr = simpleDateFormat.format(date);
        return nowStr.equals(dateStr);
    }
}
