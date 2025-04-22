package com.dfzl.material.bean.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.bean.JeecgEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 物料申请(AfMaterialApply)Po
 *
 * @author makejava
 * @since 2025-01-14 18:37:55
 */
@Data
@ApiModel(value = "物料申请Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("AF_MATERIAL_APPLY")
public class AfMaterialApply extends JeecgEntity {

    @ApiModelProperty(value = "表单编号")
    private String formNo;

    @ApiModelProperty(value = "表单标题")
    private String title;

    @ApiModelProperty(value = "物料分类")
    private String materialCategoryCode;

    @ApiModelProperty(value = "申请说明")
    private String applyReason;

    @ApiModelProperty(value = "店铺简称")
    private String entityName;

    @ApiModelProperty(value = "店铺编码")
    private String entityCode;

    @ApiModelProperty(value = "申请部门")
    private String orgCode;

    @ApiModelProperty(value = "流程状态")
    private String actStatus;

    @ApiModelProperty(value = "流程实例ID")
    private String procInstId;

    @ApiModelProperty(value = "流程定义ID")
    private String procDefId;

    @TableLogic
    private Integer delFlag;

}
