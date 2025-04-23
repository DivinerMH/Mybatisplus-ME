package com.menghuan.HuanTools.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import com.menghuan.HuanTools.bean.api.ApiCode;
import com.menghuan.HuanTools.valid.BusinessValidator;

/**
 * 自增编码工具
 * 
 * @since 2025-01-14
 * @author menghuan
 */
public final class SerializableCodeUtil {

    private static final String RESOURCE_OVERFLOW_NOT_EXISTS = "今日编码已达最大值，请明日再试";
    private static final String FORMAT_STR = "yyyyMMdd";
    private static final String FORMAT_STR_ALL = "yyyyMMddHHmmssSSS";
    private static final String INIT_CODE = "0000";

    /**
     * 基于时间的自增编码工具
     *
     * @param currStr 当前最大序列（参考：20250110000000）
     * @return 编码Code
     */
    public static String incrementCode(String currStr) {
        if (StringUtils.isBlank(currStr)) {
            return LocalDate.now().format(DateTimeFormatter.ofPattern(FORMAT_STR)) + INIT_CODE;
        }
        Long temp = Long.valueOf(Long.valueOf(currStr.substring(0, 8)) + 1 + INIT_CODE);
        Long tempCheck = Long.parseLong(currStr) + 1;
        BusinessValidator.isTrue(tempCheck < temp, ApiCode.RESOURCE_OVERFLOW_NOT_EXISTS);
        return tempCheck.toString();
    }

    /**
     * 基于时间的自增编码工具
     *
     * @param currStr 当前最大序列（参考：20250110000000）
     * @param init 初始化编码位数（参考：000000）
     * @return 编码Code
     */
    public static String incrementCode(String currStr, String init) {
        if (StringUtils.isBlank(currStr)) {
            return LocalDate.now().format(DateTimeFormatter.ofPattern(FORMAT_STR)) + init;
        }
        Long temp = Long.valueOf(Long.valueOf(currStr.substring(0, 8)) + 1 + init);
        Long tempCheck = Long.parseLong(currStr) + 1;
        BusinessValidator.isTrue(tempCheck < temp, ApiCode.RESOURCE_OVERFLOW_NOT_EXISTS);
        return tempCheck.toString();
    }

    /**
     * 基于时间的自增编码工具
     *
     * @param currStr 当前最大序列（参考：20250110000000）
     * @param init 初始化编码位数（参考：000000）
     * @return 编码Code
     */
    public static String incrementCode(String currStr, String init, String prefix) {
        if (StringUtils.isNotBlank(prefix)) {
            currStr = currStr.replace(prefix, "");
        }
        if (StringUtils.isBlank(currStr)) {
            return LocalDate.now().format(DateTimeFormatter.ofPattern(FORMAT_STR)) + init;
        }
        Long temp = Long.valueOf(Long.valueOf(currStr.substring(0, 8)) + 1 + init);
        Long tempCheck = Long.parseLong(currStr) + 1;
        BusinessValidator.isTrue(tempCheck < temp, ApiCode.RESOURCE_OVERFLOW_NOT_EXISTS);
        return tempCheck.toString();
    }

    /**
     * 基于时间的随机编码工具
     *
     * @return 编码Code
     */
    public static String incrementTimeCode() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMAT_STR_ALL))
            + Math.round(Math.random() * 10000);
    }

    public static void main(String[] args) {
        System.out.println(incrementTimeCode());
    }

}