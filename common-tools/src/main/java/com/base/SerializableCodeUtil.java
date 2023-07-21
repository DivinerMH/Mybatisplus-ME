package com.base;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import com.api.ApiCode;

/**
 * 自增编码工具
 */
public final class SerializableCodeUtil {

    /**
     * 基于时间的自增编码工具
     *
     * @param currStr 当前最大序列
     * @return 编码Code
     * @throws ServerException
     */
    public static String incrementCode(String currStr) throws ServerException {
        String yyyyMMdd = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        if (StringUtils.isBlank(currStr)) {
            return yyyyMMdd + "0000";
        }
        Long temp = Long.valueOf(Long.valueOf(currStr.substring(0, 8)) + 1 + "0000");
        Long tempCheck = Long.valueOf(currStr) + 1;
        if (tempCheck >= temp) {
            throw new ServerException(ApiCode.RESOURCE_OVERFLOW_NOT_EXISTS);
        }
        return tempCheck.toString();
    }

    /**
     * 基于时间的自增编码工具
     *
     * @param currStr 当前最大序列
     * @return 编码Code
     * @throws ServerException
     */
    public static String incrementCode(String currStr, String init) throws ServerException {
        String yyyyMMdd = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        if (StringUtils.isBlank(currStr)) {
            return yyyyMMdd + init;
        }
        Long temp = Long.valueOf(Long.valueOf(currStr.substring(0, 8)) + 1 + init);
        Long tempCheck = Long.valueOf(currStr) + 1;
        if (tempCheck >= temp) {
            throw new ServerException(ApiCode.RESOURCE_OVERFLOW_NOT_EXISTS);
        }
        return tempCheck.toString();
    }

}
