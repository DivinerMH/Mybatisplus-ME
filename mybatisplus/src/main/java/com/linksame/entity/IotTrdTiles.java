package com.linksame.entity;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 3d-tiles 文件数据表(IotTrdTiles)表实体类
 *
 * @author menghuan
 * @since 2022-08-26 10:47:22
 */
@Data
@ApiModel(value = "3d-tiles 文件数据表实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotTrdTiles implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id", name = "id")
    private Integer id;
    /**
     * 平台租户id（数据边界）
     */
    @ApiModelProperty(value = "平台租户id（数据边界）", name = "tenantId")
    private Integer tenantId;
    /**
     * 类型：0-普通3D模型 1-构件3D模型
     */
    @ApiModelProperty(value = "类型：0-普通3D模型 1-构件3D模型", name = "type")
    private String type;
    /**
     * 资产结构id
     */
    @ApiModelProperty(value = "资产结构id", name = "structureId")
    private Integer structureId;
    /**
     * 3d-tiles 文件名称
     */
    @ApiModelProperty(value = "3d-tiles 文件名称", name = "name")
    private String name;
    /**
     * 3d-tiles 数据格式：0-3dTiles 1-其他
     */
    @ApiModelProperty(value = "3d-tiles 数据格式：0-3dTiles 1-其他", name = "abbrDataFormat")
    private String abbrDataFormat;
    /**
     * 3d-tiles 入口路劲
     */
    @ApiModelProperty(value = "3d-tiles 入口路劲", name = "abbrUrl")
    private String abbrUrl;
    /**
     * 3d-tiles 入口路劲（外部资源）
     */
    @ApiModelProperty(value = "3d-tiles 入口路劲（外部资源）", name = "abbrUrlOuter")
    private String abbrUrlOuter;
    /**
     * 资源标识 : 0-内部资源 1-外部资源
     */
    @ApiModelProperty(value = "资源标识 : 0-内部资源 1-外部资源", name = "resourceIcon")
    private String resourceIcon;
    /**
     * 经度（tiles_position）
     */
    @ApiModelProperty(value = "经度（tiles_position）", name = "lng")
    private String lng;
    /**
     * 维度（tiles_position）
     */
    @ApiModelProperty(value = "维度（tiles_position）", name = "lat")
    private String lat;
    /**
     * 高度（tiles_position）
     */
    @ApiModelProperty(value = "高度（tiles_position）", name = "height")
    private String height;
    /**
     * 方向（tiles_position）
     */
    @ApiModelProperty(value = "方向（tiles_position）", name = "heading")
    private String heading;
    /**
     * 构建与资产结构关系 Json
     */
    @ApiModelProperty(value = "构建与资产结构关系 Json", name = "buildStructure")
    private String buildStructure;
    /**
     * 状态：0-启用 1-禁用
     */
    @ApiModelProperty(value = "状态：0-启用 1-禁用", name = "status")
    private String status;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private LocalDateTime updateTime;
    /**
     * 逻辑删：0-正常 1-删除
     */
    @TableLogic
    @ApiModelProperty(value = "逻辑删：0-正常 1-删除", name = "delFlag")
    private String delFlag;

}
