package com.hanchan.tools;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author:menghuan
 * @Date:2020/5/26 14:18
 * @Description 根据系统时间，处理参数时间，获取两者时间间隔
 * @Show long finalResul 示例：最终时间间隔（小时）：38小时
 */
public class TimeDeal {

    @Test
    public void detailTime1() throws Exception {

        //格式化日期的对象(转化成习惯的时间格式)
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy年MM月dd日");

        //静态方法getInstance()使用默认时区和语言环境获得一个日历。
        Calendar calendar = Calendar.getInstance();

        //输出当前系统时间;
        System.out.println("当前系统时间: " + sdFormat.format(calendar.getTime()));

        //add()增加日期，以天为单位（Calendar封装了很多静态的操作时间的单位）
        //增加10天，负数则为减少天数
        calendar.add(Calendar.DATE, 10);

        //输出增加10天后的时间;
        System.out.println("增加10天后的时间: " + sdFormat.format(calendar.getTime()));

        //输出3个月前的时间;
        calendar.add(Calendar.MONTH, -3);
        System.out.println("3个月前的时间: " + sdFormat.format(calendar.getTime()));

        //输出时间为2020年的第100天
        Date date = sdFormat.parse("2020年01月01日");
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 99);
        System.out.println("2020年的第100天: " + sdFormat.format(calendar.getTime()));
    }

    @Test
    public void detailTime2() throws ParseException {
        /*
         * 计算两个时间间隔
         */
        Date date = new Date();// 创建Date类型对象

        // 创建SimpleDateFormat类型对象、 "yyyy-MM-dd HH:ss:mm.SSS"是正则式，分别表示年月日时分秒毫秒
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm.SSS");

        // 定义两个时间
        String startTime = "1949-10-1 00:00:00.00";
        String endTime = "2018-8-21 20:00:00.00";

        // 将两个String类型的时间转换为Date类型，从而计算差值、parse()方法的作用是将String类型的时间解析为Date类型
        Date d1 = df.parse(startTime);
        Date d2 = df.parse(endTime);

        System.out.println((((d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000))) / 365 + "年");
        System.out.println((d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000) + "天");
        System.out.println((((d2.getTime() - d1.getTime()) / (60 * 60 * 1000)) % 24) + "小时");
        System.out.println((((d2.getTime() - d1.getTime()) / 1000) % 60) + "分钟");
        System.out.println(((d2.getTime() - d1.getTime()) / (60 * 1000)) % 60 + "秒");
        System.out.println((((d2.getTime() - d1.getTime())) % 1000) + "毫秒");
    }


    @Test
    public void myDetailTime() throws ParseException {
        /**
         * 计算两个时间间隔
         */
        Date date = new Date(); // 创建Date类型对象

        // 创建SimpleDateFormat类型对象、 "yyyy-MM-dd HH:ss:mm"，分别表示年月日时分秒
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");

        // new Date()为获取当前系统时间
        System.out.println("当前系统时间：" + df.format(date));

        // 定义两个时间
        String startTime = "1949-10-1 00:00:00";
        String endTime = "2018-8-21 20:00:00.00";

        // 将两个String类型的时间转换为Date类型，从而计算差值、parse()方法的作用是将String类型的时间解析为Date类型
        Date d1 = df.parse(startTime);
        Date d2 = df.parse(endTime);

        System.out.println((((d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000))) / 365 + "年");
        System.out.println((d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000) + "天");
        System.out.println((((d2.getTime() - d1.getTime()) / (60 * 60 * 1000)) % 24) + "小时");
        System.out.println((((d2.getTime() - d1.getTime()) / 1000) % 60) + "分钟");
        System.out.println(((d2.getTime() - d1.getTime()) / (60 * 1000)) % 60 + "秒");
        System.out.println((((d2.getTime() - d1.getTime())) % 1000) + "毫秒");
    }

    @Test
    public void myDetailTime2() throws ParseException {
        /**
         * 计算两个时间间隔
         */
        Date date = new Date(); // 创建Date类型对象

        // 创建SimpleDateFormat类型对象、 "yyyy-MM-dd HH:ss:mm"，分别表示年月日时分秒
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");

        // 定义两个时间 - startTime数据库读取的时间 endTime当前系统时间
        String startTime = "2020-05-26 01:59:45";
        String endTime = df.format(date);

        // 将两个String类型的时间转换为Date类型，从而计算差值、parse()方法的作用是将String类型的时间解析为Date类型
        Date d1 = df.parse(startTime);
        Date d2 = df.parse(endTime);

        long longDealTime = d2.getTime() - d1.getTime();
        System.out.println(longDealTime);

        long resultTime = (longDealTime / (60 * 60 * 1000)) % 24;
        long resultTime2 = longDealTime / (24 * 60 * 60 * 1000);
        System.out.println("时间间隔：" + resultTime + "小时");
        System.out.println("时间间隔：" + resultTime2 + "天");

        long finalResul = resultTime2 * 24 + resultTime;
        System.out.println("最终时间间隔（小时）：" + finalResul + "小时");

    }


}
