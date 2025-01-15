package com.material.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * 物料申请(AfMaterialApply)ReqUpdateDto
 *
 * @author makejava
 * @since 2025-01-14 18:37:58
 */
@Data
@ApiModel(value = "物料申请ReqUpdateDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqAfMaterialApplyUpdateDto {

    @NotBlank(message = "主键ID不可为空")
    @ApiModelProperty(value = "ID")
    private String id;

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

    @ApiModelProperty(value = "删除标记")
    private Integer delFlag;

}
