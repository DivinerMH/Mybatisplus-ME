package com.menghuan.HuanTools.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Administrator
 * @version Id: ChineseHolidayUtils, v 0.1 2020\4\21 0021 9:34 Administrator Exp $$
 **/
public class ChineseHolidayUtils {

    /**
     * @author
     * @description 判断是否是法定假日
     * @date Created in 21:03 2019/1/31
     **/
    public static boolean isLawHoliday(com.alibaba.fastjson.JSONArray holidays, String calendar) throws Exception {
        ChineseHolidayUtils.isValidDate(calendar);
        if (null == holidays) {
            return false;
        }
        if (holidays.contains(calendar)) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        String s = null;
        System.out.println(JSONObject.parseArray(s));
    }

    /**
     * @author
     * @description 当天是否为法定节假日补休周末
     * @date Created in 21:03 2019/1/31
     **/
    public static boolean isLawHolidayWork(com.alibaba.fastjson.JSONArray holidaysWork, String calendar) {
        ChineseHolidayUtils.isValidDate(calendar);
        if (null == holidaysWork) {
            return false;
        }
        if (holidaysWork.contains(calendar)) {
            return true;
        }
        return false;
    }

    /**
     * @author
     * @description 校验字符串是否为指定的日期格式, 含逻辑严格校验, 2007/02/30返回false
     * @date Created in 21:06 2019/1/31
     **/
    private static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy-MM-dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 设置lenient为false.
            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }

}
