package java.com.menghuan.menghuan.date;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: menghuan
 * @Date: 2020/11/20 13:15
 * @Description 时间字符串转数字
 */
public class DateNumberIntercept {

    private static final String tv_time = "2121";

    @Test
    public void times() throws ParseException {
        // new Date()为获取当前系统时间
        Date date = new Date();

        // 创建SimpleDateFormat类型对象、 "yyyy-MM-dd HH:ss:mm"，分别表示年月日时分秒
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        System.out.println("当前系统时间：" + df.format(date));

        SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddhhmmss");
        System.out.println("当前系统时间转数字：" + df2.format(date));

    }
}
