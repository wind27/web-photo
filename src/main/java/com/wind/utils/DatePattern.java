package com.wind.utils;

/**
 * DatePattern
 *
 * @author qianchun 2019/1/15
 **/
public enum  DatePattern {
    CT_M("yyyy-MM"),
    CT_D("yyyy-MM-dd"),
    CT_H("yyyy-MM-dd HH"),
    CT_MM("yyyy-MM-dd HH:mm"),
    CT_S("yyyy-MM-dd HH:mm:ss"),
    CT_SS("HH:mm:ss"),

    CP_M("yyyyMM"),
    CP_D("yyyyMMdd"),
    CP_H("yyyyMMddHH"),
    CP_MM("yyyyMMddHHmm"),
    CP_S("yyyyMMddHHmmss"),
    CP_SS("HHmmss"),

    CN_M("yyyy年MM月"),
    CN_D("yyyy年MM月dd日"),
    CN_H("yyyy年MM月dd日 HH时"),
    CN_MM("yyyy年MM月dd日 HH时mm分"),
    CN_S("yyyy年MM月dd日 HH时mm分ss秒"),
    CN_SS("HH时mm分ss秒"),

    CS_M("yyyy.MM"),
    CS_D("yyyy.MM.dd"),
    CS_H("yyyy.MM.dd HH"),
    CS_MM("yyyy.MM.dd HH:mm"),
    CS_S("yyyy.MM.dd HH:mm:ss");

    private String pattern;

    DatePattern(String pattern){
        this.pattern = pattern;
    }

    public String getPattern(){
        return pattern;
    }
}
