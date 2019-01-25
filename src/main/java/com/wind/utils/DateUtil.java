package com.wind.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * DateUtil
 *
 * @author qianchun 2019/1/15
 **/
public class DateUtil {

    /**
     * date转 yyyy-MM-dd HH:mm:ss
     */
    public static String format2Second(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(DatePattern.CT_S.getPattern()).format(date);
    }

    /**
     * timestamp转 yyyy-MM-dd HH:mm:ss
     */
    public static String format2Second(long timestamp) {
        return new SimpleDateFormat(DatePattern.CT_S.getPattern()).format(new Date(timestamp));
    }

    /**
     * timestamp转 yyyy-MM-dd
     */
    public static String format2Day(long timestamp) {
        return new SimpleDateFormat(DatePattern.CT_D.getPattern()).format(new Date(timestamp));
    }

    /**
     * yyyyMMddhhmmss 转 Date
     *
     * @param s str
     * @return date
     */
    public static Date strToDate(String s) {
        try {
            Date date = new SimpleDateFormat(DatePattern.CP_S.getPattern()).parse(s);
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * str 转 date
     *
     * @param str
     * @return
     */
    public static Date str2Date(String str, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * date 转 str
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String date2Str(Date date, String pattern) {
        try {
            return new SimpleDateFormat(pattern).format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 默认向后,即 1 代表获取一天之后
     *
     * @param date
     * @param days
     * @param minutes
     * @param seconds
     * @return
     */
    public static Date after(Date date, int year, int month, int days, int hour, int minutes, int seconds) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.YEAR, year);
        calender.add(Calendar.MONTH, month);
        calender.add(Calendar.DAY_OF_MONTH, days);
        calender.add(Calendar.HOUR, hour);
        calender.add(Calendar.MINUTE, minutes);
        calender.add(Calendar.SECOND, seconds);
        Date time = calender.getTime();
        return time;
    }

    /**
     * 获取本月第一天
     *
     * @return
     */
    public static Date firstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    /**
     * 获取当日0时(24小时制)
     * @return 当日0时对应日期对象
     */
    public static Date zeroDateOfToday(){
        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        return now.getTime();
    }
}
