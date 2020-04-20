package com.hzcloud.iot.asset.structure.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资产结构关联表
 * </p>
 *
 * @author menghuan
 * @since 2020-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotAssetStructure implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资产结构id
     */
    private Integer structureId;

    /**
     * 资产id
     */
    private Integer assetId;


}
