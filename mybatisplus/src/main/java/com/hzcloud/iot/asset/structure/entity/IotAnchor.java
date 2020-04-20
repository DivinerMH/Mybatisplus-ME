package com.hzcloud.iot.asset.structure.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 锚点表
 * </p>
 *
 * @author menghuan
 * @since 2020-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotAnchor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备 id
     */
    private Integer machineId;

    /**
     * 资产结构 id
     */
    private Integer structureId;

    /**
     * 摄像头 id
     */
    private String cameraId;

    /**
     * 锚点名称
     */
    private String name;

    /**
     * 锚点类型（1-平面 2-地图）
     */
    private String type;

    /**
     * 平面坐标(aa，bc)
     */
    private String coordinates;

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
