package com.menghuan.designPattern.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
@Builder
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String sex;
}