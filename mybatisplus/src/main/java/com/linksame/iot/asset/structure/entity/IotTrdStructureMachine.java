package com.linksame.entity;


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
 * 3D模型组件与资产结构设备关系(IotTrdStructureMachine)表实体类
 *
 * @author menghuan
 * @since 2022-04-19 14:16:45
 */
@Data
@ApiModel(value = "3D模型组件与资产结构设备关系实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotTrdStructureMachine implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id", name = "id")
    private Integer id;
    /**
     * 数据来源：0-平台 1-导入
     */
    @ApiModelProperty(value = "数据来源：0-平台 1-导入", name = "dataSources")
    private String dataSources;
    /**
     * 数据完善：0-已完善 1-未完善
     */
    @ApiModelProperty(value = "数据完善：0-已完善 1-未完善", name = "dataPerfect")
    private String dataPerfect;
    /**
     * 挂载类型：0-资产 1-设备 2-摄像头 3-虚拟设备锚点
     */
    @ApiModelProperty(value = "挂载类型：0-资产 1-设备 2-摄像头 3-虚拟设备锚点", name = "type")
    private String type;
    /**
     * 构件id（绑定资产或设备）
     */
    @ApiModelProperty(value = "构件id（绑定资产或设备）", name = "trdNodeId")
    private String trdNodeId;
    /**
     * 构件坐标（辅助前端数据）
     */
    @ApiModelProperty(value = "构件坐标（辅助前端数据）", name = "trdNodeCoordinate")
    private String trdNodeCoordinate;
    /**
     * 资产结构id
     */
    @ApiModelProperty(value = "资产结构id", name = "structureId")
    private Integer structureId;
    /**
     * 设备id
     */
    @ApiModelProperty(value = "设备id", name = "machineId")
    private String machineId;
    /**
     * 3D模型id
     */
    @ApiModelProperty(value = "3D模型id", name = "trdTilesId")
    private Integer trdTilesId;
    /**
     * 产品 id（设备附属信息）
     */
    @ApiModelProperty(value = "产品 id（设备附属信息）", name = "productId")
    private Integer productId;
    /**
     * 资产结构级联id数组（资产结构附属信息）
     */
    @ApiModelProperty(value = "资产结构级联id数组（资产结构附属信息）", name = "structureIdCascade")
    private String structureIdCascade;
    /**
     * 构建告警颜色
     */
    @ApiModelProperty(value = "构建告警颜色", name = "buildColorAlarm")
    private String buildColorAlarm;
    /**
     * 构建正常颜色
     */
    @ApiModelProperty(value = "构建正常颜色", name = "buildColorNormal")
    private String buildColorNormal;
    /**
     * 构建离线颜色
     */
    @ApiModelProperty(value = "构建离线颜色", name = "buildColorOffline")
    private String buildColorOffline;

}
