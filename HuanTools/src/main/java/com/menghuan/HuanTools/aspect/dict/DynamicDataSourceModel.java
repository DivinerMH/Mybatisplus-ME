package com.menghuan.HuanTools.aspect.dict;

import org.springframework.beans.BeanUtils;

import lombok.Data;

/**
 * @Description: 数据源
 * @author: jeecg-boot
 */
@Data
public class DynamicDataSourceModel {

    public DynamicDataSourceModel() {

    }

    public DynamicDataSourceModel(Object dbSource) {
        if (dbSource != null) {
            BeanUtils.copyProperties(dbSource, this);
        }
    }

    /**
     * id
     */
    private String id;
    /**
     * 数据源编码
     */
    private String code;
    /**
     * 数据库类型
     */
    private String dbType;
    /**
     * 驱动类
     */
    private String dbDriver;
    /**
     * 数据源地址
     */
    private String dbUrl;

//    /**
//     * 数据库名称
//     */
//    private java.lang.String dbName;

    /**
     * 用户名
     */
    private String dbUsername;
    /**
     * 密码
     */
    private String dbPassword;

}