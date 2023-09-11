package com.cateyes.smart.park.report.bean.po;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 企业亩均效益指标设置(SpEnterpriseMuBenefitTarget)Po
 *
 * @author CatEyes
 * @since 2023-07-21 15:43:27
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_enterprise_mu_benefit_target")
public class EnterpriseMuBenefitTarget implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @TableField(value = "target_value")
    @ApiModelProperty(value = "指标")
    private String targetValue;

    @TableId(value = "fiducial_value", type = IdType.AUTO)
    private Double fiducialValue;

    @TableField(value = "weight_value")
    @ApiModelProperty(value = "权重（%）")
    private Double weightValue;

    @TableField(value = "remark")
    @ApiModelProperty(value = "备注说明")
    private String remark;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Integer updateBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

}
