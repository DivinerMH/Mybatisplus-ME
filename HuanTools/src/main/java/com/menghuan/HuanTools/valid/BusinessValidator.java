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
     * 是有构造,防止被实现
     */
    private BusinessValidator() {
        super();
    }

    public static void isBlank(String value) {
        if (StringUtils.isNotBlank(value)) {
            throw new ServerException("参数不为空");
        }
    }

    public static void isBlank(String value, ApiCode apiCode) {
        if (StringUtils.isNotBlank(value)) {
            throw new ServerException(apiCode);
        }
    }

    /**
     * 校验字符串必须为空（否则抛异常）
     * 
     * @param value 被校验字符串
     * @param msg 参数名称（用于错误消息）
     */
    public static void isBlank(String value, String msg) {
        if (StringUtils.isNotBlank(value)) {
            throw new ServerException(String.format("参数{%s}不为空", msg));
        }
    }

    public static void isNotBlank(String value) {
        if (StringUtils.isBlank(value)) {
            throw new ServerException("参数为空");
        }
    }

    public static void isNotBlank(String value, ApiCode apiCode) {
        if (StringUtils.isBlank(value)) {
            throw new ServerException(apiCode);
        }
    }

    /**
     * 校验字符串必须非空（否则抛异常）
     * 
     * @param value 被校验字符串
     * @param msg 参数名称（用于错误消息）
     */
    public static void isNotBlank(String value, String msg) {
        if (StringUtils.isBlank(value)) {
            throw new ServerException(String.format("参数{%s}为空", msg));
        }
    }

    public static void isNull(Object obj) {
        if (obj != null) {
            throw new ServerException("参数不为NULL");
        }
    }

    public static void isNull(Object obj, ApiCode apiCode) {
        if (obj != null) {
            throw new ServerException(apiCode);
        }
    }

    /**
     * 校验对象必须为null（否则抛异常）
     * 
     * @param obj 被校验对象
     * @param msg 参数名称（用于错误消息）
     */
    public static void isNull(Object obj, String msg) {
        if (obj != null) {
            throw new ServerException(String.format("参数{%s}不为NULL", msg));
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

    /**
     * 校验对象必须为null（否则抛异常）
     * 
     * @param obj 被校验对象
     * @param msg 参数名称（用于错误消息）
     */
    public static void isNotNull(Object obj, String msg) {
        if (null == obj) {
            throw new ServerException(String.format("参数{%s}为NULL", msg));
        }
    }

    /**
     * 校验集合必须为空（否则抛异常）
     * 
     * @param collection 被校验集合
     * @param paramName 参数名称（用于错误消息）
     */
    public static void isEmpty(Collection<?> collection, String paramName) {
        if (collection != null && !collection.isEmpty()) {
            throw new ServerException(String.format("集合[%s]必须为空，当前大小：%d", paramName, collection.size()));
        }
    }

    /**
     * 校验集合必须非空（否则抛异常）
     * 
     * @param collection 被校验集合
     * @param paramName 参数名称（用于错误消息）
     */
    public static void isNotEmpty(Collection<?> collection, String paramName) {
        if (collection == null || collection.isEmpty()) {
            throw new ServerException(String.format("集合[%s]不能为空", paramName));
        }
    }

    public static void isTrue(boolean condition, String str) {
        if (!condition) {
            throw new ServerException(str);
        }
    }

    public static void isTrue(boolean condition, ApiCode apiCode) {
        if (!condition) {
            throw new ServerException(apiCode);
        }
    }

    /**
     * 通用条件校验（否则抛异常）
     * 
     * @param condition 必须为true的条件
     * @param apiCode 错误码
     * @param message 错误描述（支持%s占位符）
     * @param params 占位符参数
     */
    public static void isTrue(boolean condition, ApiCode apiCode, String message, Object... params) {
        if (!condition) {
            throw new ServerException(apiCode, String.format(message, params));
        }
    }

}
