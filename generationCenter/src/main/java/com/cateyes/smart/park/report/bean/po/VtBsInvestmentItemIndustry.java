package com.cateyes.smart.park.report.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.mybatis.MetaData;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 智慧大屏-手工-招商项目-产业项目分布(SpVtBsInvestmentItemIndustry)Po
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:38
 */
@Data
@ApiModel(value = "智慧大屏-手工-招商项目-产业项目分布Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sp_vt_bs_investment_item_industry")
public class VtBsInvestmentItemIndustry extends MetaData {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "招商项目Id")
    private Integer investmentItemId;

    @ApiModelProperty(value = "产业名称")
    private String industryName;

    @ApiModelProperty(value = "已签约项目数(个)")
    private Integer projectSignTotal;

    @ApiModelProperty(value = "已签约项目金额(万元)")
    private Double projectSignAmountTotal;

}
