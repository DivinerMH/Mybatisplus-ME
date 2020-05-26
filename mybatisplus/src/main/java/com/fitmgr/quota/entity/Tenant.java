package com.fitmgr.quota.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 租户表
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Tenant implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户名称
     */
    private String name;

    /**
     * 英文名
     */
    private String englishName;

    /**
     * 租户类型id
     */
    private Integer typeId;

    /**
     * 租户描述
     */
    private String description;

    /**
     * 状态 0-启用 1-禁用
     */
    private String status;

    /**
     * 上级id 一级租户默认为0
     */
    private Integer parentId;

    /**
     * 是否可以创建project   0-可以  1-不可以
     */
    private String createProject;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删 0-正常 1-删除
     */
    private String delFlag;


}
