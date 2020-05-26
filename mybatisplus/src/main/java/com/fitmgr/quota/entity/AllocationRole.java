package com.fitmgr.quota.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色分配表
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AllocationRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前角色id
     */
    private Integer currentRoleId;

    /**
     * 角色id
     */
    private Integer roleId;


}
