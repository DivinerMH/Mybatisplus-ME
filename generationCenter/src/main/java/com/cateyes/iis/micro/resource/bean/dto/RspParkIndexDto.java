package com.cateyes.iis.micro.resource.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * (IisParkIndex)RspDto
 *
 * @author CatEyes
 * @since 2023-10-17 11:11:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspParkIndexDto implements Serializable {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "园区、区域id")
    private Integer parkId;

    @ApiModelProperty(value = "上报时间")
    private Date reportTime;

    @ApiModelProperty(value = "上报组织")
    private Integer reportOrganize;

    @ApiModelProperty(value = "上报人")
    private Integer reportBy;

    @ApiModelProperty(value = "规模以上工业总产值（亿元）")
    private Double scaleOutput;

    @ApiModelProperty(value = "规模以上工业总产值-目标值（亿元）")
    private Double scaleOutputArm;

    @ApiModelProperty(value = "规模以上工业总产值-同比增速（%）")
    private Double scaleOutputAccelerate;

    @ApiModelProperty(value = "规模以上工业增加值（亿元）")
    private Double scaleIncrement;

    @ApiModelProperty(value = "规模以上工业增加值-同比增速（%）")
    private Double scaleIncrementAccelerate;

    @ApiModelProperty(value = "全口径税收（亿元）")
    private Double fullApertureTax;

    @ApiModelProperty(value = "全口径税收-同比增速（%）")
    private Double fullApertureTaxAccelerate;

    @ApiModelProperty(value = "累计已完成园区总产值")
    private Double hasAccumulatedOutput;

    @ApiModelProperty(value = "本年度目标产值")
    private Double annualOutputArm;

    @ApiModelProperty(value = "工业投资（亿元）")
    private Double industrialInvestment;

    @ApiModelProperty(value = "工业投资-同比增速（%）")
    private Double industrialInvestmentAccelerate;

    @ApiModelProperty(value = "固定资产投资（亿元）")
    private Double fixedInvestment;

    @ApiModelProperty(value = "固定资产投资-同比增速（%）")
    private Double fixedInvestmentAccelerate;

    @ApiModelProperty(value = "工业园区批准（认定规划面积）（亩）")
    private Double industrialAppreveArea;

    @ApiModelProperty(value = "累计获得用地指标面积（亩）")
    private Double accumulatedLandUseIndexArea;

    @ApiModelProperty(value = "划入城镇开发边界面积（亩）")
    private Double urbanDevelopmentBoundaryArea;

    @ApiModelProperty(value = "已开发面积（亩）")
    private Double hasDevelopedArea;

    @ApiModelProperty(value = "尚可供应工业用地面积（亩）")
    private Double supplyIndustrialLandArea;

    @ApiModelProperty(value = "尚可供应土地面积（亩）")
    private Double supplyLandArea;

    @ApiModelProperty(value = "新征收土地面积（亩）")
    private Double newLevyLandArea;

    @ApiModelProperty(value = "已回收、征收土地面积（亩）")
    private Double hasRecoveredLeviedLandArea;

    @ApiModelProperty(value = "熟地面积（亩）")
    private Double cultivatedLandArea;

    @ApiModelProperty(value = "正在回收、征收土地面积（亩）")
    private Double recoveredLeviedLandArea;

    @ApiModelProperty(value = "累计用于工业用地指标占比（%）")
    private Double accumulatedIndustrialLandRatio;

    @ApiModelProperty(value = "新增标准厂房面积（亩）")
    private Double newStandardPlantArea;

    @ApiModelProperty(value = "园区专项债获取额度（亿元）")
    private Double specialDebtObtainQuota;

    @ApiModelProperty(value = "基础建设项目数-在建(个)")
    private Double infrastructureProjectBuildingTotal;

    @ApiModelProperty(value = "园区成立以来累计完成基础配套设施投入资金额（亿元）")
    private Double supportingFacilitiesHasInvestmentTotal;

    @ApiModelProperty(value = "基础设施投资额（亿元）")
    private Double infrastructureInvestmentTotal;

    @ApiModelProperty(value = "园区专项债获取额度占所在县 (市、区) 额度比重（%）")
    private Double specialDebtObtainQuotaRatio;

    @ApiModelProperty(value = "规上工业企业总数量（个）")
    private Double scaleTotal;

    @ApiModelProperty(value = "新增规上工业企业数量（个）")
    private Double scaleAddTotal;

    @ApiModelProperty(value = "总投资额（亿元）")
    private Double investmentTotal;

    @ApiModelProperty(value = "已完成投资额（亿元）")
    private Double hasInvestmentTotal;

    @ApiModelProperty(value = "在建工业项目数量（个）")
    private Double projectIndustrialBuildingTotal;

    @ApiModelProperty(value = "在建项目-今年来完成投资额（亿元）")
    private Double projectBuildingHasInvestmentTotal;

    @ApiModelProperty(value = "新签约项目数量（个）")
    private Double projectSignTotal;

    @ApiModelProperty(value = "新签约项目立项投资额（亿元）")
    private Double projectSignApprovalInvestment;

    @ApiModelProperty(value = "新开工项目数量（个）")
    private Double projectStartUpTotal;

    @ApiModelProperty(value = "新开工项目立项投资额（亿元）")
    private Double projectStartUpApprovalInvestment;

    @ApiModelProperty(value = "新投产项目数量（个）")
    private Double projectOperationTotal;

    @ApiModelProperty(value = "新投产项目投资额（亿元）")
    private Double projectOperationInvestment;

    @ApiModelProperty(value = "是否启用：1-是 2-否")
    private Integer isEnable;

    @ApiModelProperty(value = "状态：1-草稿 2-审核中 3-通过 4-驳回 5-撤销 6-已归档")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createAt;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "修改时间")
    private Date updateAt;

    @ApiModelProperty(value = "修改人")
    private Integer updateBy;

    /*-----------------------------非数据库属性------------------------------*/

}
