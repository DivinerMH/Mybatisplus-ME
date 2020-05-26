package com.fitmgr.quota.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 租户类型表
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TenantType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户类型名称
     */
    private String typeName;

    /**
     * 租户类型描述
     */
    private String description;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否限制配额 0 -限制 1-不限制
     */
    private String isLimit;

    /**
     * 逻辑删：0-正常 1-删除
     */
    private String delFlag;


}
