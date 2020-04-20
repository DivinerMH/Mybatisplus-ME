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
 * @since 2020-03-18
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
     * 层级路径
     */
    private String path;

    /**
     * 省市区 id
     */
    private Integer provinceId;

    /**
     * 产品 id 
     */
    private Integer productId;

    /**
     * 地图范围
     */
    private String mapScope;

    /**
     * 平面地图（图片）
     */
    private String planimetricMap;

    /**
     * 名称
     */
    private String name;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 组织类型
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
