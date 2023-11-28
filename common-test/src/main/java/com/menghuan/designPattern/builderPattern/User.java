package com.menghuan.designPattern.builderPattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 生成器模式 - 经典用例
 * @author menghuan
 */
@Data
@Builder
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String sex;
}