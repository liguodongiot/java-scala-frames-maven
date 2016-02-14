package com.lgd.jkxy.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDate累使用了ISO日历表示年月日
 *
 * 常用方法
 * LocalDate.now(): 获取系统当前日期
 * LocalDate.of(int year,int month,int dayOfMonth):
 * 按照指定日期创建LocalDate对象
 *
 *
 * LocalTime常用方法
 * LocalTime.now(): 获取系统当前时间
 * LocalTime.of(int hour,int minute,int second):
 * 按照指定时间创建LocalTime对象
 *
 *
 * LocalDateTime常用方法
 * LocalDateTime.now(): 获取系统当前日期时间
 * LocalDateTime.of(int year,int month,int dayOfMonth,
 *                  int hour,int minute,int second):
 * 按照指定日期时间创建LocalDateTime对象
 *
 *
 * DateTimeFormatter--将字符串解析为日期
 *
 * 常用方法
 * public static DateTimeFormatter ofPattern(String pattern)
 * 作用：按pattern字符串指定的格式创建DateTimeFormatter对象
 *
 * public static LocalDateTime parse(CharSequence text, DateTimeFormatter formatter)
 *
 *
 * ZonedDateTime 处理日期和时间与相应的时区
 * 常用方法：
 * ZonedDateTime.now() 获取系统当前日期和时间
 * String format(DateTimeFormatter formatter)
 *  按指定模板将日期对象格式化为一个字符串
 *
 * Created by liguodong on 2016/1/31.
 */
public class LocalDateTimeMain {

    public static void main(String[] args) {
        localDateTest();

        localTimeTest();

        localDateTimeTest();

        dateTimeFormatterTest();

        zonedDateTimeTest();
    }

    public static void localDateTest(){
        System.out.println("---LocalDate---");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getYear() + "年"
                + localDate.getMonthValue() + "月"
                + localDate.getDayOfMonth() + "日");
        System.out.println(localDate.toString());


        LocalDate definedate = LocalDate.of(2015,10,13);
        System.out.println(definedate.toString());
    }


    public static void localTimeTest(){

        System.out.println("---LocalTime---");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour()+"时"
                        +localTime.getHour()+"分"
                        +localTime.getSecond()+"秒");

        System.out.println(localTime.toString());

    }

    public static void localDateTimeTest(){
        System.out.println("---LocalDateTime---");

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getYear()+"年"
                +localDateTime.getMonthValue()+"月"
                +localDateTime.getDayOfMonth()+"日"+
                localDateTime.getHour()+"时"
                +localDateTime.getHour()+"分"
                +localDateTime.getSecond()+"秒");
        System.out.println(localDateTime.toString());

    }

    /**
     * 将字符串格式化为一个LocalDateTime对象
     */
    public static void dateTimeFormatterTest(){
        System.out.println("---DateTimeFormatter---");
        DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2014-04-01:13:24:01", formatter);
        System.out.println(dateTime.toString());
    }

    /**
     * 将当前日期格式化为字符串并显示年月日时分秒
     */
    public static void zonedDateTimeTest(){
        System.out.println("---ZonedDateTime---");
        ZonedDateTime dateTime = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy:HH:mm:ss");
        String strDate = dateTime.format(formatter);
        System.out.println(strDate);
    }

}
