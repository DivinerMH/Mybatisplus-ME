package com.fitmgr.quota.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 配额表
 * </p>
 *
 * @author menghuan
 * @since 2019-12-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Quota implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 配额id(雪花算法生成18位)
     */
    private Long quotaId;

    /**
     * 配额项id
     */
    private Integer quotaItemId;

    /**
     * 资源类型 0-无 1-vmware 2-openStack
     */
    private String resourceType;

    /**
     * 配额总量
     */
    private Integer quotaTotal;

    /**
     * 配额余量
     */
    private Integer quotaSurplus;

    /**
     * 租户或项目id
     */
    private Integer tpId;

    /**
     * 配额类型 0-租户 1-project
     */
    private String quotaType;

    /**
     * 弹性伸缩组 0-否 1-是
     */
    private String elasticExpansion;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除(0=正常,1=删除)
     */
    private String delFlag;


}
