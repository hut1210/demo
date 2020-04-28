package com.example.demo.test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * @Author: Hut
 * @Date: 2020/04/10 17:04
 **/
public class Test {

    public static void main(String[] args) {
        System.out.println(dateDiff(getDateTimeOfTimestamp(1586424420000L),getDateTimeOfTimestamp(System.currentTimeMillis())));

        long days = (System.currentTimeMillis()- 1586424420000L)/ (1000 * 60 * 60 * 24);
        System.out.println(days);

    }
    public static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    public static int dateDiff(LocalDateTime dt1, LocalDateTime dt2){
        //获取第一个时间点的时间戳对应的秒数
        long t1 = dt1.toEpochSecond(ZoneOffset.ofHours(0));
        //获取第一个时间点在是1970年1月1日后的第几天
        long day1 = t1 /(60*60*24);
        //获取第二个时间点的时间戳对应的秒数
        long t2 = dt2.toEpochSecond(ZoneOffset.ofHours(0));
        //获取第二个时间点在是1970年1月1日后的第几天
        long day2 = t2/(60*60*24);
        //返回两个时间点的天数差
        return (int)(day2 - day1);
    }
}
