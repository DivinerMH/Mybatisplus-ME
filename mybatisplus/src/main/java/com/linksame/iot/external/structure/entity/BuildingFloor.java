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
 * 资源管理-楼层表(BuildingFloor)表实体类
 *
 * @author menghuan
 * @since 2022-03-11 15:50:30
 */
@Data
@ApiModel(value = "资源管理-楼层表实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BuildingFloor implements Serializable {

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
     * 项目id
     */
    @ApiModelProperty(value = "项目id", name = "projectId")
    private Long projectId;
    /**
     * 项目分期id
     */
    @ApiModelProperty(value = "项目分期id", name = "subProjectId")
    private Long subProjectId;
    /**
     * 楼宇id
     */
    @ApiModelProperty(value = "楼宇id", name = "buildingId")
    private Long buildingId;
    /**
     * 楼层名称
     */
    @ApiModelProperty(value = "楼层名称", name = "floorName")
    private String floorName;

    @ApiModelProperty(value = "", name = "floorHeight")
    private Double floorHeight;
    /**
     * 楼层归属（0-地下,1-地上）
     */
    @ApiModelProperty(value = "楼层归属（0-地下,1-地上）", name = "floorGroundUpdown")
    private Integer floorGroundUpdown;

    @ApiModelProperty(value = "", name = "bearing")
    private Double bearing;
    /**
     * 电梯数量
     */
    @ApiModelProperty(value = "电梯数量", name = "liftNum")
    private Integer liftNum;
    /**
     * 户型图
     */
    @ApiModelProperty(value = "户型图", name = "houseImg")
    private String houseImg;
    /**
     * 平面单元图
     */
    @ApiModelProperty(value = "平面单元图", name = "planeGraphImg")
    private String planeGraphImg;
    /**
     * 楼层标识
     */
    @ApiModelProperty(value = "楼层标识", name = "sortNum")
    private Integer sortNum;
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
     * 房间坐标
     */
    @ApiModelProperty(value = "房间坐标", name = "roomCoordinates")
    private String roomCoordinates;
    /**
     * 房源编号
     */
    @ApiModelProperty(value = "房源编号", name = "floorNum")
    private Integer floorNum;

}
