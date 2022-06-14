package com.linksame.iot.external.structure.entity;


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
 * 资源管理-楼宇表(Building)表实体类
 *
 * @author menghuan
 * @since 2022-03-11 15:50:14
 */
@Data
@ApiModel(value = "资源管理-楼宇表实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Building implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID", name = "id")
    private Long id;
    /**
     * 公司id
     */
    @ApiModelProperty(value = "公司id", name = "companyId")
    private Long companyId;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id", name = "projectId")
    private Long projectId;
    /**
     * 分期id
     */
    @ApiModelProperty(value = "分期id", name = "subProjectId")
    private Long subProjectId;
    /**
     * 楼宇名称
     */
    @ApiModelProperty(value = "楼宇名称", name = "buildingName")
    private String buildingName;
    /**
     * 楼宇编号
     */
    @ApiModelProperty(value = "楼宇编号", name = "buildingCode")
    private String buildingCode;
    /**
     * 楼宇别名
     */
    @ApiModelProperty(value = "楼宇别名", name = "buildingAlias")
    private String buildingAlias;
    /**
     * 楼宇地址
     */
    @ApiModelProperty(value = "楼宇地址", name = "buildingAddress")
    private String buildingAddress;
    /**
     * 楼层数（地上）
     */
    @ApiModelProperty(value = "楼层数（地上）", name = "upFloorLevel")
    private Integer upFloorLevel;
    /**
     * 楼层数（地下）
     */
    @ApiModelProperty(value = "楼层数（地下）", name = "underFloorLevel")
    private Integer underFloorLevel;
    /**
     * 电梯数量
     */
    @ApiModelProperty(value = "电梯数量", name = "liftNum")
    private Integer liftNum;
    /**
     * 是否有备用发电机
     */
    @ApiModelProperty(value = "是否有备用发电机", name = "backPowerFlag")
    private Integer backPowerFlag;

    @ApiModelProperty(value = "", name = "planArchitectureArea")
    private Double planArchitectureArea;
    /**
     * 楼宇竣工日期
     */
    @ApiModelProperty(value = "楼宇竣工日期", name = "completionDate")
    private LocalDateTime completionDate;
    /**
     * 楼宇主图
     */
    @ApiModelProperty(value = "楼宇主图", name = "buildingImg")
    private String buildingImg;

    @ApiModelProperty(value = "", name = "buildingDescription")
    private String buildingDescription;
    /**
     * 删除标识
     */
    @ApiModelProperty(value = "删除标识", name = "deleteFlag")
    private Integer deleteFlag;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", name = "creator")
    private String creator;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;
    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人", name = "modifier")
    private String modifier;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间", name = "modifyTime")
    private LocalDateTime modifyTime;
    /**
     * 单元总数
     */
    @ApiModelProperty(value = "单元总数", name = "totalRoomNum")
    private Integer totalRoomNum;

    @ApiModelProperty(value = "", name = "totalArchitectureArea")
    private Double totalArchitectureArea;

    @ApiModelProperty(value = "", name = "remark")
    private String remark;

}
