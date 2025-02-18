package com.menghuan.ddl.bean;

import java.util.List;

import lombok.Data;

/**
 * @Author: menghuan
 * @Date: 2025-02-08 17:03
 */
@Data
public class ForeignKeyInfo {
    private String fkName;
    private String pkTableName;
    private List<String> pkColumns;
    private List<String> fkColumns;

}