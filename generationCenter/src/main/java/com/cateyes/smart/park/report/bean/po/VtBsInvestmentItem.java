package com.cateyes.smart.park.report.bean.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.mybatis.MetaData;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 智慧大屏-手工-招商项目(SpVtBsInvestmentItem)Po
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:16
 */
@Data
@ApiModel(value = "智慧大屏-手工-招商项目Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sp_vt_bs_investment_item")
public class VtBsInvestmentItem extends MetaData {

    @TableId(value = "id", type = IdType.AUTO)
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

}
