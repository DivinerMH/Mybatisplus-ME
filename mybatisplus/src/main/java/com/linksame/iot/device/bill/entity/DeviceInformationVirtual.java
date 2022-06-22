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
 * 虚拟设备台账表(DeviceInformationVirtual)表实体类
 *
 * @author menghuan
 * @since 2022-04-11 16:24:28
 */
@Data
@ApiModel(value = "虚拟设备台账表实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DeviceInformationVirtual implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键 id", name = "id")
    private Integer id;
    /**
     * 设备台账 id ( 设备类型 )
     */
    @ApiModelProperty(value = "设备台账 id ( 设备类型 )", name = "deviceId")
    private Integer deviceId;
    /**
     * 设备 id（设备类型)
     */
    @ApiModelProperty(value = "设备 id（设备类型)", name = "machineId")
    private String machineId;
    /**
     * BIM构件 id
     */
    @ApiModelProperty(value = "BIM构件 id", name = "bimId")
    private String bimId;
    /**
     * 构件颜色
     */
    @ApiModelProperty(value = "构件颜色", name = "trdNodeColor")
    private String trdNodeColor;
    /**
     * 资产结构 id（位置信息）
     */
    @ApiModelProperty(value = "资产结构 id（位置信息）", name = "locationId")
    private Integer locationId;
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
