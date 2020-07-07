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
 * @since 2020-07-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotAnchor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型：0-设备锚点 1-摄像头锚点 2-公司（租户）锚点
     */
    private String type;

    /**
     * 资产结构 id
     */
    private Integer structureId;

    /**
     * 产品 id
     */
    private Integer productId;

    /**
     * 设备 id
     */
    private Integer machineId;

    /**
     * 锚点名称
     */
    private String name;

    /**
     * 平面坐标(aa，bc)
     */
    private String planCoordinates;

    /**
     * GIS坐标(aa，bc)
     */
    private String gisCoordinates;

    /**
     * Bimserver坐标（aab，abc，cba）
     */
    private String bimCoordinates;

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
