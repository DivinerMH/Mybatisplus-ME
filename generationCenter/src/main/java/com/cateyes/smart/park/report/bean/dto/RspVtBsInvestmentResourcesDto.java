package com.cateyes.smart.park.report.bean.dto;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 智慧大屏-手工-招商资源(SpVtBsInvestmentResources)RspDto
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:47
 */
@Data
@ApiModel(value = "智慧大屏-手工-招商资源RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspVtBsInvestmentResourcesDto implements Serializable {

    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "园区Id")
    private Integer parkId;

    @ApiModelProperty(value = "园区名称")
    private String parkName;

    @ApiModelProperty(value = "年月")
    private Date date;

    @ApiModelProperty(value = "是否省产业园：1-是 2-否")
    private Integer isProvincePark;

    @ApiModelProperty(value = "所在区域Id")
    private Integer regionId;

    @ApiModelProperty(value = "上报组织")
    private String reportOrganize;

    @ApiModelProperty(value = "上报人")
    private String reportPerson;

    @ApiModelProperty(value = "上报日期")
    private Date reportTime;

    @ApiModelProperty(value = "规划面积(亩)")
    private Double areaPlan;

    @ApiModelProperty(value = "认定规划面积(亩)")
    private Double areaPlanAffirm;

    @ApiModelProperty(value = "收储总面积(亩)")
    private Double areaStorage;

    @ApiModelProperty(value = "新征收土地面积(亩)")
    private Double areaLandNewCollect;

    @ApiModelProperty(value = "新整备土地面积(亩)")
    private Double areaLandPrepared;

    @ApiModelProperty(value = "建设用地面积(亩)")
    private Double areaLandBuild;

    @ApiModelProperty(value = "工业用地面积(亩)")
    private Double areaLandIndustry;

    @ApiModelProperty(value = "土地投资强度(万元/公顷)")
    private Double landInvestmentIntensity;

    @ApiModelProperty(value = "尚可供工业用地面积(亩)")
    private Double areaLandAvailableSupply;

    @ApiModelProperty(value = "尚可供熟地面积(亩)")
    private Double areaLandCultivated;

    @ApiModelProperty(value = "已批未供面积(亩)")
    private Double areaApprovedNotSupply;

    @ApiModelProperty(value = "已批未建面积(亩)")
    private Double areaApprovedNotBuilt;

    @ApiModelProperty(value = "已签约土地面积(亩)")
    private Double areaLandSigned;

    @ApiModelProperty(value = "在建面积(亩)")
    private Double areaConstruct;

    @ApiModelProperty(value = "已建成面积(亩)")
    private Double areaBuilt;

    @ApiModelProperty(value = "招商房源-总建筑面积(平方米)")
    private Double houseAreaArchitecture;

    @ApiModelProperty(value = "招商房源-房源数")
    private Integer houseTotal;

    @ApiModelProperty(value = "招商房源-房源总面积(平方米)")
    private Double houseArea;

    @ApiModelProperty(value = "已租-已租售房源总面积(平方米)")
    private Double houseAreaRented;

    @ApiModelProperty(value = "已租-其中标准厂房面积(平方米)")
    private Double houseAreaRentedStandardFactory;

    @ApiModelProperty(value = "已租-其中办公楼面积(平方米)")
    private Double houseAreaRentedOffice;

    @ApiModelProperty(value = "待租-待租售房源总面积(平方米)")
    private Double houseAreaRent;

    @ApiModelProperty(value = "待租-其中标准厂房面积(平方米)")
    private Double houseAreaRentStandardFactory;

    @ApiModelProperty(value = "待租-其中办公楼面积(平方米)")
    private Double houseAreaRentOffice;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /*-----------------------------非数据库属性------------------------------*/

}
