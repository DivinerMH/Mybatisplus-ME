package com.menghuan.HuanTools.utils;

import java.rmi.ServerException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

/**
 * 自增编码工具
 * 
 * @author Administrator
 */
public final class SerializableCodeUtil {

    private static final String RESOURCE_OVERFLOW_NOT_EXISTS = "今日编码已达最大值，请明日再试";
    private static final String INIT_BIT_LESS_THAN_DEFAULT_VALUE = "初始化位数小于默认值";
    private static final String FORMAT_STR = "yyyyMMdd";
    private static final String FORMAT_STR_ALL = "yyyyMMddHHmmssSSS";
    private static final String INIT_CODE = "000000";

    /**
     * 基于时间的自增编码工具
     *
     * @param currStr 当前最大序列（参考：20250110000000）
     * @return 编码Code
     * @throws ServerException
     */
    public static String incrementCode(String currStr) throws Exception {
        if (StringUtils.isBlank(currStr)) {
            return LocalDate.now().format(DateTimeFormatter.ofPattern(FORMAT_STR)) + INIT_CODE;
        }
        // 极限数据（位数）设置
        Long resultLimit = Long.valueOf(Long.valueOf(currStr.substring(0, 8)) + 1 + INIT_CODE);
        Long result = Long.parseLong(currStr) + 1;
        if (result >= resultLimit) {
            throw new Exception(RESOURCE_OVERFLOW_NOT_EXISTS);
        }
        return result.toString();
    }

    /**
     * 基于时间的自增编码工具
     *
     * @param currStr 当前最大序列（参考：20250110000000）
     * @param init 初始化编码（参考：000000）
     * @return 编码Code
     * @throws ServerException
     */
    public static String incrementCode(String currStr, String init) throws Exception {
        if (init.length() < INIT_CODE.length()){
            throw new Exception(INIT_BIT_LESS_THAN_DEFAULT_VALUE);
        }
        if (StringUtils.isBlank(currStr)) {
            return LocalDate.now().format(DateTimeFormatter.ofPattern(FORMAT_STR)) + init;
        }
        Long resultLimit = Long.valueOf(Long.valueOf(currStr.substring(0, 8)) + 1 + init);
        Long result = Long.parseLong(currStr) + 1;
        if (result >= resultLimit) {
            throw new Exception(RESOURCE_OVERFLOW_NOT_EXISTS);
        }
        return result.toString();
    }

    /**
     * 基于时间的自增编码工具 - 规则：年月日时分秒毫秒+5位随机数字（例如：202501141709090294333）
     * 
     * @return 编码Code
     */
    public static String incrementTimeCode() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMAT_STR_ALL))
            + Math.round(Math.random() * 10000);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(incrementCode("20250114000000"));
        System.out.println(incrementCode("20250114000250","000000"));
        // System.out.println(incrementCode("20250114999999","000000"));
        System.out.println(incrementTimeCode());
    }

}
