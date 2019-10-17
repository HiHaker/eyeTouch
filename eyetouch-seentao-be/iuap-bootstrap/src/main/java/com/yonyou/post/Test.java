package com.yonyou.post;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created on 2019/10/17 0017
 * BY Jianlong
 */
public class Test {

    // 时间模式
    private static final DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        // 构造当日0点localdate对象
        String zeroDate = LocalDateTime.now().format(datePattern);
        String zeroDateTimeString = zeroDate + " " + "00:00:00";
        LocalDateTime zeroDateTime = LocalDateTime.parse(zeroDateTimeString, dateTimePattern);
        String postTime;
        postTime = "2019-10-17 15:27:24";
        // 发帖的时间转换为localdate对象
        LocalDateTime postDateTime = LocalDateTime.parse(postTime, dateTimePattern);
        long days = ChronoUnit.DAYS.between(zeroDateTime, postDateTime);
        System.out.println(days);
    }
}