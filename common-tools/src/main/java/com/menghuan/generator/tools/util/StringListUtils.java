package com.menghuan.generator.tools.util;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringListUtils {
    /**
     * 把原始字符串分割成指定长度的字符串列表
     *
     * @param inputString
     *            原始字符串
     * @param length
     *            指定长度
     * @return
     */
    public static List<String> getStrList(String inputString, int length) {
        int size = inputString.length() / length;
//        if (inputString.length() % length != 0) {
//            size += 1;
//        }
        return getStrList(inputString, length, size);
    }


    /**
     * 把原始字符串分割成指定长度的字符串列表
     *
     * @param inputString
     *            原始字符串
     * @param length
     *            指定长度
     * @param size
     *            指定列表大小
     * @return
     */
    private static List<String> getStrList(String inputString, int length,
                                          int size) {
        List<String> list = new ArrayList<String>();
        for (int index = 0; index < size; index++) {
            String childStr = substring(inputString, index * length,
                    (index + 1) * length);
            list.add(childStr);
        }
        return list;
    }

    /**
     * 分割字符串，如果开始位置大于字符串长度，返回空
     *
     * @param str
     *            原始字符串
     * @param f
     *            开始位置
     * @param t
     *            结束位置
     * @return
     */
    public static String substring(String str, int f, int t) {
        if (f > str.length())
            return null;
        if (t > str.length()) {
            return str.substring(f, str.length());
        } else {
            return str.substring(f, t);
        }
    }


    /**
     * 计算选定字符出现了多少次
     * @param target 目标字符
     * @param str 字符串
     * @return
     */
    public static int getCount(String target,String str){
        int count=0;	// 定义计数器
        int index=0;	// 定义角标

        while((index=str.indexOf(target))!=-1){
            // sp("str"+str);
            str=str.substring(index+target.length());	// 截取未被查找到目标字符串的子串
            count++;
        }
        return count;
    }



    /**
     * 高转低
     * @param s 高位在前字符串
     * @return
     */
    public static String getStringListHighLowConversion(String s){
        List<String> list = StringListUtils.getStrList(s,2);
        Collections.reverse(list);
        return String.join("",list);
    }

    /**
     * 低转高
     * @param s 低位在前字符串
     * @return
     */
    public static String getStringListLowHighConversion(String s){
        List<String> list = StringListUtils.getStrList(s,2);
        Collections.reverse(list);
        return String.join("",list);
    }

    /**
     * 二进制数据前后位转换
     * @param s
     * @return
     */
    public static String getBinaryStringLowHighConversion(String s){
        List<String> list = StringListUtils.getStrList(s,1);
        Collections.reverse(list);
        return String.join("",list);
    }

    /**
     * 加法
     * @param total
     * @param current
     * @return
     */
    public static String add(String total,String current){
        try{
            double tt = 0.0;
            double cc = 0.0;
            try{
                tt = Double.parseDouble(total);
            }catch(Exception e){
            }
            try{
                cc = Double.parseDouble(current);
            }catch(Exception e){
            }
            return String.valueOf(tt+cc);
        }catch(Exception e){
            return "";
        }

    }
    /**
     * 减法
     * @param total
     * @param current
     * @return
     */
    public static String subtraction(String total,String current){
        try{
            double tt = 0.0;
            double cc = 0.0;
            try{
                tt = Double.parseDouble(total);
            }catch(Exception e){
            }
            try{
                cc = Double.parseDouble(current);
            }catch(Exception e){
            }
            return String.valueOf(tt-cc);
        }catch(Exception e){
            return "";
        }

    }

    /**
     * 乘法
     * @param one
     * @param two
     * @return
     */
    public static String multiplication(String one,String two){
        try{
            double tt = 0.0;
            double cc = 0.0;
            try{
                tt = Double.parseDouble(one);
            }catch(Exception e){
            }
            try{
                cc = Double.parseDouble(two);
            }catch(Exception e){
            }
            BigDecimal bd = new BigDecimal(String.valueOf(tt * cc));
            return bd.toPlainString();
        }catch(Exception e){
            return "";
        }
    }

    /**
     * 除法
     * @param all
     * @param complate
     * @return
     */
    public static String division(String all,String complate){
        try{
            double tt = 0.0;
            double cc = 0.0;
            try{
                tt = Double.parseDouble(all);
            }catch(Exception e){
            }
            try{
                cc = Double.parseDouble(complate);
            }catch(Exception e){
            }
            if(tt==0.0){
                return "0";
            }else{
                BigDecimal bd = new BigDecimal(String.valueOf(tt / cc));
                return bd.toPlainString();
            }
        }catch(Exception e){
            return "0";
        }
    }

    public static String getDecimal(String source,int length){
        if(source == null){
            return "0";
        }
        if(source.indexOf(".") > -1){
            String intger = source.split("\\.")[0];
            String end = source.split("\\.")[1];
            if(end != null && end.length() > length){
                end = end.substring(0,length);
            }
            return intger+"."+end;
        }
        return source;
    }

    public static void main(String[] a){
        //System.out.println(getDecimal("1.1234sad5",3));
	/*System.out.println(getStrClcj("-10.45","11"));
	System.out.println(getStrClcj("-11","11"));*/
//        System.out.println(getCode("08标"));
        List<String> list = StringListUtils.getStrList("0000010111110000",1);
        Collections.reverse (list);
//        StringListUtils.division("3","3600000000000");

        System.out.println (list.toString ());
    }

    public static String getPercentage(String numerator, String fraction) {
        try{
            double n = 0.0;
            double f = 1.0;
            try{
                n = Double.parseDouble(numerator);
            }catch(Exception e){
            }
            try{
                f = Double.parseDouble(fraction);
            }catch(Exception e){
            }
            return getDecimal(String.valueOf(n / f * 100),3);
        }catch(Exception e){
            return "0";
        }
    }

    /**
     * 获取行数
     * @param data
     * @return
     */
    public static int getAllLine(String data){
        String str = dealNull(data);
        String[] array = str.split("\n");
        return array.length;
    }
    /**
     * 获取行数
     * @param data
     * @return
     */
    public static int getAllLine(Object data){
        String str = dealNull(data);
        String[] array = str.split("\n");
        return array.length;
    }
    /**
     * 获取行数
     * @param data
     * @return
     */
    public static int getLine(Object data) {
        String str = dealNull(data);
        String[] array = str.split("\n");
        int length = array.length;
        int num = length;
        for (int i = 0; i < length; i++) {
            int arylength = array[i].length();
            if (arylength > 50) {
                num = num + arylength / 50;
            }
        }
        return num;
    }

    /**
     * 处理上传空格-换行
     * @param data
     * @return
     */
    public static String dealSpace(String data){
        String ret = data;
        if(StringUtils.isBlank(ret) || "null".equals(ret)){
            return "";
        }
        return ret.replaceAll(" ", "").replaceAll("\n","").replaceAll("\r", "");
    }

    public static String convertString(Object value) {
        if (value == null) {
            return "";
        } else {
            return value.toString();
        }
    }

    public static String dealNull(Object data){
        String ret = String.valueOf(data);
        if(StringUtils.isBlank(ret) || "null".equals(ret)){
            return "";
        }
        return ret;
    }

    public static String dealSpace(Object data){
        String ret = String.valueOf(data);
        if(StringUtils.isBlank(ret) || "null".equals(ret)){
            return "";
        }
        return ret.replaceAll(" ", "").replaceAll("\n","");
    }

    /**
     * 去掉特殊字符
     * "[`~!@#$%^&*()+-=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]"
     * @param data
     * @return
     */
    public static String dealSpecial(Object data){
        String ret = String.valueOf(data);
        if(StringUtils.isBlank(ret) || "null".equals(ret)){
            return "";
        }
        ret = ret.replaceAll("_", "");
        ret = ret.replaceAll("-", "");
        String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?～！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(ret);
        return m.replaceAll("").trim();
    }

    /**
     * String转number
     * @param num 1-取1位小数，2-取2位小数
     * @param str
     * @return
     */
    public static String getStringNumber(int num,Object data){
        try{
            String str = String.valueOf(data);
            if(StringUtils.isNotBlank(str) && !"null".equals(str)){
                BigDecimal bd = new BigDecimal(str);
                return bd.setScale(num, BigDecimal.ROUND_HALF_UP).toString();
            }
            return "0";
        }catch(Exception e){
            return "0";
        }
    }

    /**
     * String转number
     * @param num 1-取1位小数，2-取2位小数
     * @param str
     * @return
     */
    public static String getStringNumber2(int num,Object data){
        try{
            String str = String.valueOf(data);
            if(StringUtils.isNotBlank(str) && !"null".equals(str)){
                BigDecimal bd = new BigDecimal(str);
                return bd.setScale(num, BigDecimal.ROUND_HALF_UP).toString();
            }
            return "";
        }catch(Exception e){
            return "";
        }
    }
    /**
     * String转number
     * @param num 保留小数位数
     * @param bd 大数字
     * @return
     */
    public static String getStringNumber(int num, BigDecimal bd){
        return bd.setScale(num, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 上传excel 项目编码出现精度问题调整
     * @param num  1-取1位小数，2-取2位小数
     * @param str 4.4000000000000004  4.0999999999999996
     * @return
     */
    public static String getStringXmbm(int num,String str){
        if(StringUtils.isNotBlank(str)){
            if(str.indexOf("999999")>0 || str.indexOf("000000")>0){
                BigDecimal bd = new BigDecimal(str);
                return bd.setScale(num, BigDecimal.ROUND_HALF_UP).toString();
            }
        }
        return str;
    }

    public static double getDoubleNum(int num,Double d) {
        try{
            BigDecimal bg = new BigDecimal(d);
            return bg.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }


    /**
     * 数据字符处理
     * @param str 数字型
     * @return  非空去掉空格，空返回“0.00”
     */
    public static String isNotBlankTrim(String str){
        if(StringUtils.isNotBlank(str) && !"null".equals(str)){
            return str.trim();
        }else{
            return "0";
        }
    }

    /**
     * 数据字符处理
     * @param str 数字型
     * @return  非空去掉空格，空返回“0.00”
     */
    public static String isNotBlankTrim(Object str){
        String str1 = String.valueOf(str);
        return isNotBlankTrim(str1);
    }

    /**
     * 获取字符串行数
     * @param str
     * @return
     */
    public static int getRowsNum(String str){
        if(StringUtils.isNotBlank(str)){
            String[] array = str.split("\n");
            return array.length;
        }
        return 0;
    }

    /**
     * 获取字符串中的中文字符串
     * @param str
     * @return
     */
    public static String getCodeCN(String str){
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        StringBuffer reStr = new StringBuffer();
        while (m.find()) {
            reStr.append(m.group());
        }
        return reStr.toString();
    }
    /**
     * 获取字符串中的非中文字符串
     * 从第一位是字母的开始截取
     * @param str
     * @return
     */
    public static String getCode(String str){
        StringBuffer sb = new StringBuffer();
        if(StringUtils.isNotBlank(str)){
            for (int i = 0; i < str.length(); i++) {
                if ((str.charAt(i)+"").getBytes().length==1) {
                    if(sb.length()==0 && isAsciiLetter(str.charAt(i))){
                        sb.append(str.charAt(i));
                    }else if(sb.length()>0){
                        sb.append(str.charAt(i));
                    }
                }
            }
        }
        return sb.toString();
    }

    private static boolean isAsciiLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    /**
     * 获取标段数据
     * @param str
     * @return
     */
    public static String getCodeNum(String str){
        StringBuffer sb = new StringBuffer();
        if(StringUtils.isNotBlank(str)){
            String str2 = str.split("-")[1];
            for (int i = 0; i < str2.length(); i++) {
                if ((str2.charAt(i)+"").getBytes().length==1) {
                    sb.append(str2.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    /**
     * 补充位数，不够的在前面补0
     * @param num 总共需要位数
     * @param str 需要补充的字符
     * @return
     */
    public static String getStrCode(int num,Object str){
        if(null != str && !"null".equals(str)){
            String reStr = String.valueOf(str);
            int len = reStr.length();
            if(num>len){
                for(int i=len;i<num;i++){
                    reStr = "0"+reStr;
                }
            }
            return reStr;
        }
        return "";
    }

    public static String qryQsxx(String qsxx,int n){
        if(StringUtils.isNotBlank(qsxx)){
            int num = Integer.valueOf(qsxx) + n;
            return getStrCode(3, num);
        }
        return "001";
    }
    //只适用于日期格式字符 yyyy-MM-DD
    public static String getYearMonth(String ksrq,String jsrq){
        try{
            String year = getYear(ksrq);
            String month = getMonth(ksrq) + "-" + getMonth(jsrq);
            return year +" 年 "+ month +" 月";
        }catch(Exception e){
            return "";
        }
    }
    //只适用于日期格式字符 yyyy-MM-DD
    public static String getYear(String str){
        try{
            return str.split("-")[0];
        }catch(Exception e){
            return "";
        }
    }
    //只适用于日期格式字符 yyyy-MM-DD
    public static String getMonth(String str){
        try{
            return str.split("-")[1];
        }catch(Exception e){
            return "";
        }
    }

    /**
     * 根据单位获取保留小数位数
     * @param jldw
     * @return
     */
    public static int getNumDoul(String jldw){
        try{
            if("m".equals(jldw) || "m2".equals(jldw) || "m3".equals(jldw)
                    || "㎡".equals(jldw) || "m³".equals(jldw)){
                return 2;
            }else if("kg".equals(jldw) || "t".equals(jldw)
                    || "KG".equals(jldw) || "T".equals(jldw)){
                return 3;
            }
            return 2;
        }catch(Exception e){
            return 0;
        }
    }

    public static String changeUnit(String unit){
        String str = dealSpace(unit);
        if("m2".equals(str)){
            str = "㎡";
        }else if("m3".equals(str)){
            str = "m³";
        }else if("T".equals(str)){
            str = "t";
        }else if("KG".equals(str)){
            str = "kg";
        }
        return str;
    }

    /**
     * 进行乘法运算
     * @param d1
     * @param d2
     * @return
     */
    public static BigDecimal mul(double d1, double d2) { //
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.multiply(b2);
    }

    /**
     * 进行乘法运算
     * @param d1
     * @param d2
     * @return
     */
    public static BigDecimal mul(String d1, String d2) { //
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.multiply(b2);
    }


    /**
     * 数字比较
     * @param str1
     * @param str2
     * @return  str1>str2 返回1；str1<str2 返回-1；str1=str2 返回0
     */
    public static int compareTo(String str1,String str2){
        try{
            String t1 = dealSpace(str1);
            String t2 = dealSpace(str2);
            if(StringUtils.isNotBlank(t1) && StringUtils.isNotBlank(t2)){
                BigDecimal bd = new BigDecimal(t1);
                return bd.compareTo(new BigDecimal(t2));
            }else if(StringUtils.isNotBlank(t1) && StringUtils.isBlank(t2)){
                return 1;
            }else if(StringUtils.isBlank(t1) && StringUtils.isNotBlank(t2)){
                return -1;
            }
        }catch (Exception e) {
            return 0;
        }
        return 0;
    }

    /**
     * 0-特殊处理（当数据为0史返回空）
     * @param val
     * @return
     */
    public static String dealZero (String val){
        String str = dealSpace(val);
        int num = compareTo(str, "0");
        if(num==0){
            return "";
        }
        return str;
    }

    /**
     * 0-特殊处理（当数据为0史返回空）
     * @param val
     * @return
     */
    public static String dealZero (Object val){
        String str = dealSpace(val);
        int num = compareTo(str, "0");
        if(num==0){
            return "";
        }
        return str;
    }

    /**
     * 将小写1转成大写一
     * @param input
     * @return
     */
    public static String NumberToChinese(String input){
        String s1="一二三四五六七八九";
        // String s4="分角整元拾佰仟万拾佰仟亿拾佰仟";
        String temp="";
        String result="";
        if (input==null) return "输入的字串不是数字串只能包括以下字符（'0'~'9','.'),输入字串最大只能精确到仟亿，小数点只能两位！";
        temp=input.trim();
        float f;
        try{
            f=Float.parseFloat(temp);
        }catch(Exception e){
            return "输入的字串不是数字串只能包括以下字符（'0'~'9','.'),输入字串最大只能精确到仟亿，小数点只能两位！";
        }
        int len=0;
        if(temp.indexOf(".")==-1) len=temp.length();
        else len=temp.indexOf(".");
        //if(len>s4.length()-3) return("输入字串最大只能精确到仟亿，小数点只能两位！");
        int n1=0;
        String num="";
        String unit="";
        for(int i=0;i<temp.length();i++){
            if(i>len+2){break;}
            if(i==len) {continue;}
            n1=Integer.parseInt(String.valueOf(temp.charAt(i)));
            num=s1.substring(n1-1,n1);
            n1=len-i+2;
            // unit=s4.substring(n1,n1+1);
            result=result.concat(num).concat(unit);
        }
        //if((len==temp.length())||(len==temp.length()-1)) result=result.concat("整");
        //if(len==temp.length()-2) result=result.concat("零分");
        return result;
    }


}
