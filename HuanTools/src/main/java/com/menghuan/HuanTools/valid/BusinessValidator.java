package com.menghuan.HuanTools.valid;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;

import com.menghuan.HuanTools.bean.api.ApiCode;
import com.menghuan.HuanTools.exception.ServerException;

/**
 * 通用业务校验工具类
 * 
 * @Author: menghuan
 * @Date: 2025-02-21 15:39
 */
public class BusinessValidator<E extends RuntimeException> {

    /**
     * 私有构造 - 防止被实现重写
     */
    private BusinessValidator() {
        super();
    }

    /**
     * 校验：参数字符串为空（否则抛异常）
     * 
     * @param str 参数字符串
     */
    public static void isBlank(String str) {
        if (StringUtils.isNotBlank(str)) {
            throw new ServerException("参数不为空");
        }
    }

    /**
     * 校验：参数字符串为空（否则抛异常）
     * 
     * @param str 参数字符串
     * @param apiCode REST API 响应码
     */
    public static void isBlank(String str, ApiCode apiCode) {
        if (StringUtils.isNotBlank(str)) {
            throw new ServerException(apiCode);
        }
    }

    /**
     * 校验：参数字符串为空（否则抛异常）
     * 
     * @param str 参数字符串
     * @param attributeName 参数属性名（用于错误消息）
     */
    public static void isBlank(String str, String attributeName) {
        if (StringUtils.isNotBlank(str)) {
            throw new ServerException(String.format("参数{%s}不为空", attributeName));
        }
    }

    public static void isNotBlank(String str) {
        if (StringUtils.isBlank(str)) {
            throw new ServerException("参数为空");
        }
    }

    public static void isNotBlank(String str, ApiCode apiCode) {
        if (StringUtils.isBlank(str)) {
            throw new ServerException(apiCode);
        }
    }

    public static void isNotBlank(String str, String attributeName) {
        if (StringUtils.isBlank(str)) {
            throw new ServerException(String.format("参数{%s}为空", attributeName));
        }
    }

    /**
     * 校验：参数对象为 NULL（否则抛异常）
     * 
     * @param obj 参数对象
     */
    public static void isNull(Object obj) {
        if (obj != null) {
            throw new ServerException("参数不为NULL");
        }
    }

    /**
     * 校验：参数对象为 NULL（否则抛异常）
     * 
     * @param obj 参数对象
     * @param apiCode REST API 响应码
     */
    public static void isNull(Object obj, ApiCode apiCode) {
        if (obj != null) {
            throw new ServerException(apiCode);
        }
    }

    /**
     * 校验：参数对象为 NULL（否则抛异常）
     * 
     * @param obj 参数对象
     * @param objName 参数对象名（用于错误消息）
     */
    public static void isNull(Object obj, String objName) {
        if (obj != null) {
            throw new ServerException(String.format("参数{%s}不为NULL", objName));
        }
    }

    public static void isNotNull(Object obj) {
        if (null == obj) {
            throw new ServerException("参数为NULL");
        }
    }

    public static void isNotNull(Object obj, ApiCode apiCode) {
        if (null == obj) {
            throw new ServerException(apiCode);
        }
    }

    public static void isNotNull(Object obj, String msg) {
        if (null == obj) {
            throw new ServerException(String.format("参数{%s}为NULL", msg));
        }
    }

    /**
     * 校验：集合为空（否则抛异常）
     * 
     * @param collection 集合
     * @param paramName 参数集合名称（用于错误消息）
     */
    public static void isEmpty(Collection<?> collection, String paramName) {
        if (collection != null && !collection.isEmpty()) {
            throw new ServerException(String.format("集合[%s]必须为空，当前大小：%d", paramName, collection.size()));
        }
    }

    /**
     * 校验：集合非空（否则抛异常）
     * 
     * @param collection 集合
     * @param paramName 参数集合名称（用于错误消息）
     */
    public static void isNotEmpty(Collection<?> collection, String paramName) {
        if (collection == null || collection.isEmpty()) {
            throw new ServerException(String.format("集合[%s]不能为空", paramName));
        }
    }

    /**
     * 校验：condition 为 True（否则抛异常）
     * 
     * @param condition 判断条件
     * @param msg 信息（异常信息）
     */
    public static void isTrue(boolean condition, String msg) {
        if (!condition) {
            throw new ServerException(msg);
        }
    }

    /**
     * 校验：condition 为 True（否则抛异常）
     * 
     * @param condition 判断条件
     * @param apiCode REST API 响应码
     */
    public static void isTrue(boolean condition, ApiCode apiCode) {
        if (!condition) {
            throw new ServerException(apiCode);
        }
    }

    /**
     * 校验：condition 为 True（否则抛异常）
     * 
     * @param condition 判断条件
     * @param apiCode REST API 响应码
     * @param msg 信息（异常信息）
     * @param params 占位符参数
     */
    public static void isTrue(boolean condition, ApiCode apiCode, String msg, Object... params) {
        if (!condition) {
            throw new ServerException(apiCode, String.format(msg, params));
        }
    }

}
