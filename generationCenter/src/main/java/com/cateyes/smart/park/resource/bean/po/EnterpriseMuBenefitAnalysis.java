package com.cateyes.smart.park.resource.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业亩均效益分析-企业得分(SpEnterpriseMuBenefitAnalysis)Po
 *
 * @author CatEyes
 * @since 2023-07-25 15:55:42
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_enterprise_mu_benefit_analysis")
public class EnterpriseMuBenefitAnalysis implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "enterprise_id")
    private Integer enterpriseId;

    @TableField(value = "year")
    private Integer year;

    @TableField(value = "month")
    private Integer month;

    @TableField(value = "date")
    private Date date;

    @TableField(value = "gear_value_id")
    private Integer gearValueId;

    @TableField(value = "benefit_score")
    private Double benefitScore;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Integer updateBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

}
