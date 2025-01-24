package com.menghuan.regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: menghuan
 * @Date: 2022/7/15 17:28
 */
public class RegularMatchUtils {

    /**
     * @param rex 正则校验规则
     * @param str 要校验的字符串
     * @return 返回校验结果，若满足校验规则，则返回true，否则返回false
     */
    static Boolean match(String rex, String str) {
        // TODO Auto-generated method stub
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
