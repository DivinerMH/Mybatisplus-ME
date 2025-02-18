package com.menghuan.ddl.bean;

import lombok.Data;

/**
 * @Author: menghuan
 * @Date: 2025-02-08 17:01
 */
@Data
public class ColumnInfo {

    private String name;
    private String typeName;
    private int dataType;
    private int columnSize;
    private boolean nullable;
    private String defaultValue;

}
