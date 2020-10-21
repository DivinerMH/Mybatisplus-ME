package com.helper.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil extends StringUtils {

    public static final char   SEPARATOR        = '_';

    //获取0的字符串
    private static String getZero(int length)
    {
        StringBuilder str= new StringBuilder(length);
        for(int i=0;i<length;i++)
        {
            str.append("0");
        }
        return str.toString();
    }
    /**
     * 左侧补零
     * length  返回字符串长度
     * s的长度超过length,返回s;小于length，左侧不足补零
     */
    public static String leftZeroShift(String s,int length)
    {
        if(s==null||s.length()>length)
            return s;
        String str=getZero(length)+s;
        str=str.substring(str.length()-length);
        return str;
    }
    /**
     * 右侧补零
     * length  返回字符串长度
     * s的长度超过length,返回s;小于length，右侧不足补零
     */
    public static String rightZeroShift(String s,int length)
    {
        if(s==null||s.length()>length)
            return s;
        String str=s+getZero(length);
        str=str.substring(0,length);
        return str;
    }


    /**
     * 匹配是否为数字
     * @param str 可能为中文，也可能是-19162431.1254，不使用BigDecimal的话，变成-1.91624311254E7
     * @return
     * @author yutao
     * @date 2016年11月14日下午7:41:22
     */
    public static boolean isNumeric(String str) {
    // 该正则表达式可以匹配所有的数字 包括负数
        Pattern pattern = Pattern.compile("-?[0-9]+(\\\\.[0-9]+)?");
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }

        Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static boolean checkPort(int port){
        String regex="^(TCP|UDP) (([1-9]\\d{0,3})|([1-5]\\d{4})|(6[0-4]\\d{3})|(65[0-4]\\d{2})|(655[0-2]\\d)|(6553[0-5]))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher isPort = pattern.matcher(regex);
        return isPort.matches();
    }



    /**
     * 驼峰命名法工具
     * @return
     * 		toCamelCase("hello_world") == "helloWorld"
     * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * 		toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }

        s = s.toLowerCase();


        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
