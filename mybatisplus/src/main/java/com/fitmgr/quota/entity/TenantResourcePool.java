package com.fitmgr.quota.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TenantResourcePool implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 资源池code
     */
    private String resourcePoolCode;

    /**
     * 资源池id
     */
    private String resourcePoolId;


}
