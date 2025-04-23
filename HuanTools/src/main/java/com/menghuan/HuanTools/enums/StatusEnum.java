package com.menghuan.HuanTools.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态枚举
 *
 * @author menghuan
 * @date 2025-01-24
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

    ENABLE("0", "禁用"),
    DISABLE("1", "启用"),
    LOCK("2", "锁定")
    ;

    /**
     * 类型
     */
    private final String status;
    /**
     * 描述
     */
    private final String description;

}
