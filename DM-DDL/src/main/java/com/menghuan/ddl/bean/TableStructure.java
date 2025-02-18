package com.menghuan.ddl.bean;

import java.util.List;

import lombok.Data;

/**
 * @Author: menghuan
 * @Date: 2025-02-08 17:04
 */
@Data
public class TableStructure {
    private String tableName;
    private List<ColumnInfo> columns;
    private PrimaryKeyInfo primaryKey;
    private List<IndexInfo> indexes;
    private List<ForeignKeyInfo> foreignKeys;

}
