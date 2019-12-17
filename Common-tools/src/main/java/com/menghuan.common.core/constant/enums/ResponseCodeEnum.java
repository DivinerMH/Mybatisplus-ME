package com.fitmgr.common.core.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author bjx
 * @date 2019-11-6
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum {
    SUCCESS(0,"成功"),
    ERROR(1,"失败");

    private final int code;
    private final String desc;
}
