package com.fitmgr.quota.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 配额操作表
 * </p>
 *
 * @author menghuan
 * @since 2019-12-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QuotaOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目id
     */
    private String projectId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 组件或属性编码
     */
    private String code;

    /**
     * 组件参数
     */
    private Integer parameter;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 资源类型 0-无 1-vmware 2-openStack
     */
    private String resourceType;

    /**
     * 配额类型 0-租户 1-project
     */
    private String quotaType;

    /**
     * 配额状态：0-未扣减 1-已扣减 2-未补偿 3-已补偿
     */
    private String quotaStatus;

    /**
     * 操作状态：0-扣减 1-补偿
     */
    private String operationStatus;

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
