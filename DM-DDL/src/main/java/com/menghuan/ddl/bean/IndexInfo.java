package com.menghuan.ddl.bean;

import java.util.List;

import lombok.Data;

/**
 * @Author: menghuan
 * @Date: 2025-02-08 17:02
 */

@Data
public class IndexInfo {
    private String indexName;
    private List<String> columns;
    private boolean nonUnique;

}
