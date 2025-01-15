package com.base.util;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Nullable;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.base.ApiCode;

/**
 * Description: Assert封装类
 *
 * @author: CatEyes
 * @date: 2023/4/10 15:49
 */
public final class Assert extends org.springframework.util.Assert {
    public static void isTrue(boolean expression, ApiCode code) {
        if (!expression) {
            throw new ServerException(code);
        }
    }

    public static void isNull(@Nullable Object object, ApiCode code) {
        if (object != null) {
            throw new ServerException(code);
        }
    }

    public static void notNull(@Nullable Object object, ApiCode code) {
        if (object == null) {
            throw new ServerException(code);
        }
    }

    public static void hasLength(@Nullable String text, ApiCode code) {
        if (!StringUtils.hasLength(text)) {
            throw new ServerException(code);
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection, ApiCode code) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new ServerException(code);
        }
    }

    public static void empty(@Nullable Collection<?> collection, ApiCode code) {
        if (!CollectionUtils.isEmpty(collection)) {
            throw new ServerException(code);
        }
    }

    public static void notEmpty(@Nullable Map<?, ?> map, ApiCode code) {
        if (CollectionUtils.isEmpty(map)) {
            throw new ServerException(code);
        }
    }

    public static void empty(@Nullable Map<?, ?> map, ApiCode code) {
        if (!CollectionUtils.isEmpty(map)) {
            throw new ServerException(code);
        }
    }
}
