package com.hzcloud.iot.house.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 房源信息表
 * </p>
 *
 * @author menghuan
 * @since 2020-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotResources implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户id（关联租户）
     */
    private Integer tenantId;

    /**
     * 资产id（关联组织）
     */
    private Integer structureId;

    /**
     * 计费模型id（关联计费）
     */
    private Integer accountId;

    /**
     * 房源类型id（关联房源类型）
     */
    private Integer typeId;

    /**
     * 名称
     */
    private String name;

    /**
     * 设备
     */
    private String facilities;

    /**
     * 房源信息图片
     */
    private String picture;

    /**
     * 押金
     */
    private Integer cashPledge;

    /**
     * 标签
     */
    private String label;

    /**
     * 户型
     */
    private String houseType;

    /**
     * 面积（单位：m2）
     */
    private Double area;

    /**
     * 简介（房屋信息介绍）
     */
    private String introduction;

    /**
     * 地图位置
     */
    private String mapLocation;

    /**
     * 状态：1-上架 2-待上架 3-已租售 4-下架
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
