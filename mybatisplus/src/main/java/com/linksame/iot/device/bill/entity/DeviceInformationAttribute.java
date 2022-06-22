package com.linksame.iot.device.bill.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 虚拟设备台账属性表(DeviceInformationAttribute)表实体类
 *
 * @author menghuan
 * @since 2022-04-11 16:23:57
 */
@Data
@ApiModel(value = "虚拟设备台账属性表实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DeviceInformationAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键 id", name = "id")
    private Integer id;
    /**
     * 虚拟设备台账 id
     */
    @ApiModelProperty(value = "虚拟设备台账 id", name = "virtualId")
    private Integer virtualId;
    /**
     * 属性 id（维护维度）
     */
    @ApiModelProperty(value = "属性 id（维护维度）", name = "attributeId")
    private Integer attributeId;
    /**
     * 设备 id（虚拟设备)（方便筛选）
     */
    @ApiModelProperty(value = "设备 id（虚拟设备)（方便筛选）", name = "machineId")
    private String machineId;
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
