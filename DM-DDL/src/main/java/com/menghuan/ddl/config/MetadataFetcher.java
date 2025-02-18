package com.menghuan.ddl.config;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.menghuan.ddl.bean.*;

/**
 * @Author: menghuan
 * @Date: 2025-02-08 17:05
 */
@Component
public class MetadataFetcher {

    public static List<String> getTableNames(Connection conn) throws SQLException {
        List<String> tables = new ArrayList<>();
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet rs = meta.getTables(null, null, "%", new String[]{"TABLE"})) {
            while (rs.next()) {
                tables.add(rs.getString("TABLE_NAME"));
            }
        }
        return tables;
    }

    public static TableStructure getTableStructure(Connection conn, String tableName) throws SQLException {
        TableStructure structure = new TableStructure();
        structure.setTableName(tableName);

        // 获取列信息
        structure.setColumns(getColumns(conn, tableName));

        // 获取主键
        structure.setPrimaryKey(getPrimaryKey(conn, tableName));

        // 获取索引
        structure.setIndexes(getIndexes(conn, tableName));

        // 获取外键
        structure.setForeignKeys(getForeignKeys(conn, tableName));

        return structure;
    }

    private static List<ColumnInfo> getColumns(Connection conn, String tableName) throws SQLException {
        List<ColumnInfo> columns = new ArrayList<>();
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet rs = meta.getColumns(null, null, tableName, "%")) {
            while (rs.next()) {
                ColumnInfo col = new ColumnInfo();
                col.setName(rs.getString("COLUMN_NAME"));
                col.setTypeName(rs.getString("TYPE_NAME"));
                col.setDataType(rs.getInt("DATA_TYPE"));
                col.setColumnSize(rs.getInt("COLUMN_SIZE"));
                col.setNullable(rs.getInt("NULLABLE") == DatabaseMetaData.columnNullable);
                col.setDefaultValue(rs.getString("COLUMN_DEF"));
                columns.add(col);
            }
        }
        return columns;
    }

    private static PrimaryKeyInfo getPrimaryKey(Connection conn, String tableName) throws SQLException {
        PrimaryKeyInfo pk = new PrimaryKeyInfo();
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet rs = meta.getPrimaryKeys(null, null, tableName)) {
            List<String> columns = new ArrayList<>();
            while (rs.next()) {
                columns.add(rs.getString("COLUMN_NAME"));
            }
            pk.setColumns(columns);
        }
        return pk;
    }

    private static List<IndexInfo> getIndexes(Connection conn, String tableName) throws SQLException {
        Map<String, IndexInfo> indexMap = new LinkedHashMap<>();
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet rs = meta.getIndexInfo(null, null, tableName, false, false)) {
            while (rs.next()) {
                if (rs.getShort("TYPE") == DatabaseMetaData.tableIndexStatistic) {
                    continue;
                }
                String indexName = rs.getString("INDEX_NAME");
                IndexInfo index = indexMap.computeIfAbsent(indexName, k -> {
                    IndexInfo i = new IndexInfo();
                    i.setIndexName(indexName);
                    try {
                        i.setNonUnique(rs.getBoolean("NON_UNIQUE"));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return i;
                });
                index.getColumns().add(rs.getString("COLUMN_NAME"));
            }
        }
        return new ArrayList<>(indexMap.values());
    }

    private static List<ForeignKeyInfo> getForeignKeys(Connection conn, String tableName) throws SQLException {
        Map<String, ForeignKeyInfo> fkMap = new LinkedHashMap<>();
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet rs = meta.getImportedKeys(null, null, tableName)) {
            while (rs.next()) {
                String fkName = rs.getString("FK_NAME");
                ForeignKeyInfo fk = fkMap.computeIfAbsent(fkName, k -> {
                    ForeignKeyInfo f = new ForeignKeyInfo();
                    f.setFkName(fkName);
                    try {
                        f.setPkTableName(rs.getString("PKTABLE_NAME"));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return f;
                });
                fk.getPkColumns().add(rs.getString("PKCOLUMN_NAME"));
                fk.getFkColumns().add(rs.getString("FKCOLUMN_NAME"));
            }
        }
        return new ArrayList<>(fkMap.values());
    }
}
