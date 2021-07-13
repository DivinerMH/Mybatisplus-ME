package com.linksame.iot.visual.entity;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 组件(Component)表实体类
 *
 * @author menghuan
 * @since 2021-07-13 11:24:49
 */
@Data
@ApiModel(value = "组件实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Component implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", name = "id")
    private Integer id;
    /**
     * 组件类型id
     */
    @ApiModelProperty(value = "组件类型id", name = "componentTypeId")
    private Integer componentTypeId;
    /**
     * 模型JSON
     */
    @ApiModelProperty(value = "模型JSON", name = "modelJson")
    private String modelJson;
    /**
     * 模型名称
     */
    @ApiModelProperty(value = "模型名称", name = "modelName")
    private String modelName;
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
    @ApiModelProperty(value = "逻辑删：0-正常 1-删除", name = "delFlag")
    private String delFlag;

}
