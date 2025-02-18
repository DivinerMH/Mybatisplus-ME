package com.menghuan.ddl.bean;

import java.util.List;

import lombok.Data;

/**
 * @Author: menghuan
 * @Date: 2025-02-08 17:02
 */
@Data
public class PrimaryKeyInfo {
    private String name;
    private List<String> columns;

}
