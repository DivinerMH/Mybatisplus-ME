package java.com.menghuan.menghuan.date;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author:menghuan
 * @Date:2020/9/28 11:58
 */
public class isValidDate {

    /**
     * 验证日期格式是否满足要求
     *
     * @param str          需要验证的日期格式
     * @param formatString 验证的标准格式，如：（yyyy/MM/dd HH:mm:ss）
     * @return 返回验证结果
     */
    public static boolean isValidDate(String str, String formatString) {
        // 指定日期格式，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        try {
            // 设置lenient为false.
            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
        return true;
    }

    @Test
    public void test1() {
        String str = "2020-08-22 16:04:00";
        String formatString = "yyyy-MM-dd HH:mm:ss";
        boolean validDate = isValidDate(str, formatString);
        System.out.println(validDate);

    }

}
