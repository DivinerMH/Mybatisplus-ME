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
 * 资源管理-单元(房源)表(BuildingFloorRoom)表实体类
 *
 * @author menghuan
 * @since 2022-03-11 15:50:51
 */
@Data
@ApiModel(value = "资源管理-单元(房源)表实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BuildingFloorRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID", name = "id")
    private Long id;
    /**
     * 公司ID
     */
    @ApiModelProperty(value = "公司ID", name = "companyId")
    private Long companyId;
    /**
     * 项目ID
     */
    @ApiModelProperty(value = "项目ID", name = "projectId")
    private Long projectId;
    /**
     * 项目分期ID
     */
    @ApiModelProperty(value = "项目分期ID", name = "subProjectId")
    private Long subProjectId;
    /**
     * 楼宇ID
     */
    @ApiModelProperty(value = "楼宇ID", name = "buildingId")
    private Long buildingId;
    /**
     * 楼层ID
     */
    @ApiModelProperty(value = "楼层ID", name = "floorId")
    private Long floorId;
    /**
     * 单元编号
     */
    @ApiModelProperty(value = "单元编号", name = "roomCode")
    private String roomCode;
    /**
     * 单元性质(房源类型):办公,住宅,商业
     */
    @ApiModelProperty(value = "单元性质(房源类型):办公,住宅,商业", name = "useType")
    private Integer useType;
    /**
     * 房间状态
     */
    @ApiModelProperty(value = "房间状态", name = "businessStatus")
    private Integer businessStatus;
    /**
     * 是否公开
     */
    @ApiModelProperty(value = "是否公开", name = "isPublic")
    private Integer isPublic;

    @ApiModelProperty(value = "", name = "roomArchitectureArea")
    private Double roomArchitectureArea;

    @ApiModelProperty(value = "", name = "sleeveArchitectureArea")
    private Double sleeveArchitectureArea;
    /**
     * 支持业务类型
     */
    @ApiModelProperty(value = "支持业务类型", name = "supportBusinessType")
    private String supportBusinessType;
    /**
     * 单元别名
     */
    @ApiModelProperty(value = "单元别名", name = "roomAlias")
    private String roomAlias;
    /**
     * 单元主图
     */
    @ApiModelProperty(value = "单元主图", name = "roomImg")
    private String roomImg;
    /**
     * 单元简介
     */
    @ApiModelProperty(value = "单元简介", name = "roomComment")
    private String roomComment;
    /**
     * 采光情况:0(无)1(有)
     */
    @ApiModelProperty(value = "采光情况:0(无)1(有)", name = "lightFlag")
    private Integer lightFlag;
    /**
     * 窗户数量
     */
    @ApiModelProperty(value = "窗户数量", name = "windowNum")
    private Integer windowNum;
    /**
     * 朝向
     */
    @ApiModelProperty(value = "朝向", name = "orientations")
    private String orientations;
    /**
     * 备注说明
     */
    @ApiModelProperty(value = "备注说明", name = "remark")
    private String remark;
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
     * 删除标示（1是,0否）
     */
    @ApiModelProperty(value = "删除标示（1是,0否）", name = "deleteFlag")
    private Integer deleteFlag;
    /**
     * 是否允许删除:有业务关联的不允许删除
     */
    @ApiModelProperty(value = "是否允许删除:有业务关联的不允许删除", name = "deleteAllowFlag")
    private Integer deleteAllowFlag;
    /**
     * 异动id
     */
    @ApiModelProperty(value = "异动id", name = "changeId")
    private Long changeId;
    /**
     * 房源类别(0：正常房源，1：异动房源）
     */
    @ApiModelProperty(value = "房源类别(0：正常房源，1：异动房源）", name = "roomType")
    private Integer roomType;
    /**
     * 0:未异动 1:异动
     */
    @ApiModelProperty(value = "0:未异动 1:异动", name = "changeState")
    private Integer changeState;
    /**
     * 有效状态，0：无效，1:有效，2:暂时失效
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "有效状态，0：无效，1:有效，2:暂时失效", name = "validState")
    private Integer validState;
    /**
     * 有效截止日期，为空表示永久有效
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "有效截止日期，为空表示永久有效", name = "validTime")
    private LocalDateTime validTime;
    /**
     * 审批状态，0：无，1:异动审批中，2:变动审批中
     */
    @ApiModelProperty(value = "审批状态，0：无，1:异动审批中，2:变动审批中", name = "approveState")
    private Integer approveState;
    /**
     * 关联客户ID
     */
    @ApiModelProperty(value = "关联客户ID", name = "linkCustomerId")
    private Long linkCustomerId;
    /**
     * 关联客户名称
     */
    @ApiModelProperty(value = "关联客户名称", name = "linkCustomerName")
    private String linkCustomerName;
    /**
     * 关联操作用户ID
     */
    @ApiModelProperty(value = "关联操作用户ID", name = "linkOperateId")
    private Long linkOperateId;
    /**
     * 关联客户时间
     */
    @ApiModelProperty(value = "关联客户时间", name = "linkTime")
    private LocalDateTime linkTime;

}
