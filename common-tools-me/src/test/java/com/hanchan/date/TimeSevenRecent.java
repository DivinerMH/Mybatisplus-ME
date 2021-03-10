package com.hanchan.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author:menghuan
 * @Date:2020/5/27 14:28
 * @Description 根据系统时间，（动态）截取最近7天的日期
 * @Show ArrayList<Object> 示例：[2020-05-27, 2020-05-26, 2020-05-25, 2020-05-24, 2020-05-23, 2020-05-22, 2020-05-21]
 */
public class TimeSevenRecent {

    @Test
    public void TimeSevenRecent() {
        // String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = simpleDateFormat.format(new Date());

        System.out.println(format1);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -5);
        Date time = calendar.getTime();
        String format2 = simpleDateFormat.format(time);
        System.out.println(format2);

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(0, format1);
        objects.add(1, format2);
        System.out.println(objects);
    }

    @Test
    public void TimeSevenRecent2() {
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 可以通过该代码控制日式显示的格式 - 示例：2020-05-22
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd"); // 改格式只取月/日 - 示例：05-27
        Calendar calendar = Calendar.getInstance();    //得到一个Calendar的实例
        ArrayList<Object> timeInfo = new ArrayList<>();
        String formatRecentInfo = null;
        Date time = null;
        for (int i = 1; i < 8; i++) {
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, -(i - 1));
            time = calendar.getTime();
            formatRecentInfo = simpleDateFormat.format(time);
            timeInfo.add(i - 1, formatRecentInfo);
            System.out.println(formatRecentInfo);
        }
        System.out.println(timeInfo);
    }


}
