package com.linksame.iot.external.structure.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 资源管理-项目分期表(ParkProjectSub)表实体类
 *
 * @author menghuan
 * @since 2022-03-11 15:39:01
 */
@Data
@ApiModel(value = "资源管理-项目分期表实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ParkProjectSub implements Serializable {

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
     * 地块编号
     */
    @ApiModelProperty(value = "地块编号", name = "projectStage")
    private String projectStage;
    /**
     * 地块别名
     */
    @ApiModelProperty(value = "地块别名", name = "projectStageName")
    private String projectStageName;
    /**
     * 国家
     */
    @ApiModelProperty(value = "国家", name = "country")
    private String country;
    /**
     * 省份
     */
    @ApiModelProperty(value = "省份", name = "province")
    private String province;
    /**
     * 城市
     */
    @ApiModelProperty(value = "城市", name = "city")
    private String city;
    /**
     * 区
     */
    @ApiModelProperty(value = "区", name = "district")
    private String district;
    /**
     * 所在街道
     */
    @ApiModelProperty(value = "所在街道", name = "street")
    private String street;
    /**
     * 四至
     */
    @ApiModelProperty(value = "四至", name = "fourto")
    private String fourto;
    /**
     * 用地性质
     */
    @ApiModelProperty(value = "用地性质", name = "useType")
    private String useType;
    /**
     * 规划建筑面积
     */
    @ApiModelProperty(value = "规划建筑面积", name = "planArchitectureArea")
    private Double planArchitectureArea;
    /**
     * 容积率
     */
    @ApiModelProperty(value = "容积率", name = "capacityRate")
    private Double capacityRate;
    /**
     * 占地面积
     */
    @ApiModelProperty(value = "占地面积", name = "area")
    private Double area;
    /**
     * 规划计容面积
     */
    @ApiModelProperty(value = "规划计容面积", name = "capacityArea")
    private Double capacityArea;
    /**
     * 建筑限高
     */
    @ApiModelProperty(value = "建筑限高", name = "buildingHeightLimit")
    private String buildingHeightLimit;
    /**
     * 建筑密度
     */
    @ApiModelProperty(value = "建筑密度", name = "buildingDensity")
    private String buildingDensity;
    /**
     * 绿地率
     */
    @ApiModelProperty(value = "绿地率", name = "greenRate")
    private String greenRate;
    /**
     * 地块主图
     */
    @ApiModelProperty(value = "地块主图", name = "image")
    private String image;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;
    /**
     * 单元建筑面积汇总
     */
    @ApiModelProperty(value = "单元建筑面积汇总", name = "architectureAreaTotal")
    private Double architectureAreaTotal;
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
    @ApiModelProperty(value = "修改人", name = "modifer")
    private String modifer;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间", name = "modifyTime")
    private LocalDateTime modifyTime;
    /**
     * 删除标识
     */
    @ApiModelProperty(value = "删除标识", name = "deleteFlag")
    private Integer deleteFlag;

}
