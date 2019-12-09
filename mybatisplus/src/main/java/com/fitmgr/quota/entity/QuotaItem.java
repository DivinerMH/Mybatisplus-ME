package com.fitmgr.quota.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 配额项表
 * </p>
 *
 * @author menghuan
 * @since 2019-12-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QuotaItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 配额项名称
     */
    private String quotaName;

    /**
     * 配额项编码
     */
    private String code;

    /**
     * 上级组件id  组件的为0 ，属性的为上级组件id
     */
    private Integer parentId;

    /**
     * 配额项类型  0 - 组件  1-属性
     */
    private String type;

    /**
     * 0 启用 1 禁用
     */
    private String status;

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
