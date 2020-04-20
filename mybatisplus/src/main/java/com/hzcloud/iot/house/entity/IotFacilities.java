package com.hzcloud.iot.house.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 家居设施表
 * </p>
 *
 * @author menghuan
 * @since 2020-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotFacilities implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备类型：1-办公 2-家居 3-其他
     */
    private String type;

    /**
     * 设施名称
     */
    private String name;

    /**
     * 状态：0-启用 1-禁用
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
     * 逻辑删：0-正常 1-删除
     */
    private String delFlag;


}
