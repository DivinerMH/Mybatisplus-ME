package com.hzcloud.iot.asset.structure.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资产结构表
 * </p>
 *
 * @author menghuan
 * @since 2020-07-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotStructure implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 父级 id（默认：0）
     */
    private Integer parentId;

    /**
     * 平台租户 id（已出售不纳管）
     */
    private Integer tenantId;

    /**
     * 省市区 id
     */
    private Integer provinceId;

    /**
     * 是否已上传3D-tiles文件：0-未上传 1-已上传
     */
    private String hasTrd;

    /**
     * 3d-tiles id集合
     */
    private String trdId;

    /**
     * 视角（3d-tiles id集合数据的综合视角）
     */
    private String cameraPosition;

    /**
     * GIS地图（坐标范围）
     */
    private String gisMap;

    /**
     * 平面地图（图片）
     */
    private String planimetricMap;

    /**
     * UUID唯一标识（园区边界）
     */
    private String identification;

    /**
     * 名称
     */
    private String name;

    /**
     * 名称层级路径
     */
    private String path;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 资产类型（关联资产类型表）
     */
    private Integer orgType;

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
