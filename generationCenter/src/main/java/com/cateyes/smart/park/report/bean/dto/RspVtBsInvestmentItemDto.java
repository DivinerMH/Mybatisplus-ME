package com.cateyes.smart.park.report.bean.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 智慧大屏-手工-招商项目(SpVtBsInvestmentItem)RspDto
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:18
 */
@Data
@ApiModel(value = "智慧大屏-手工-招商项目RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspVtBsInvestmentItemDto implements Serializable {

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

    @ApiModelProperty(value = "当年计划签约项目(个)")
    private Integer planSignProjectCountCurYear;

    @ApiModelProperty(value = "当年计划签约金额（万元）")
    private Double planSignAmountCurYear;

    @ApiModelProperty(value = "当年计划招引企业(家)")
    private Integer planImportEnterpriseCountCurYear;

    @ApiModelProperty(value = "历年累计签约项目(个)")
    private Integer projectSignAcc;

    @ApiModelProperty(value = "历年累计签约项目金额(万元)")
    private Double projectSignAmountAcc;

    @ApiModelProperty(value = "当年累计签约项目(个)")
    private Integer projectSignCurYear;

    @ApiModelProperty(value = "当年累计签约项目金额(万元)")
    private Double projectSignAmountCurYear;

    @ApiModelProperty(value = "当前签约金额进度(%)")
    private Double projectSignRate;

    @ApiModelProperty(value = "当前在园企业(家)")
    private Integer enterpriseInPark;

    @ApiModelProperty(value = "当年新增入驻企业(家)")
    private Integer enterpriseEnterAddCurYear;

    @ApiModelProperty(value = "当年新增投产企业(家)")
    private Integer enterpriseOperationAddCurYear;

    @ApiModelProperty(value = "招引企业进度(%)")
    private Double enterpriseImportRate;

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
