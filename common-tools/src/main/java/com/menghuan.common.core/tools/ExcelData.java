package com.menghuan.common.core.tools;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * excel 数据
 * @author bjx
 * @date 2019-11-28
 */
@Data
public class ExcelData implements Serializable {
    // 表头
    private List<String> titles;

    // 数据
    private List<List<Object>> rows;

    // 页签名称
    private String name;
}
