package com.hzcloud.iot.house.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 家居设备-房源信息中间表
 * </p>
 *
 * @author menghuan
 * @since 2020-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotFacilitiesResources implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 家居设施id
     */
    private Integer facilitiesId;

    /**
     * 房源信息id
     */
    private Integer resourcesId;


}
