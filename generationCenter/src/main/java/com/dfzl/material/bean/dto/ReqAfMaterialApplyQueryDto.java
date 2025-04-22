package com.dfzl.material.bean.dto;

import java.util.List;

import com.base.dto.ReqBaseQueryDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 物料申请(AfMaterialApply)ReqQueryDto
 *
 * @author makejava
 * @since 2025-01-14 18:37:58
 */
@Data
@ApiModel(value = "物料申请ReqQueryDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReqAfMaterialApplyQueryDto extends ReqBaseQueryDto {

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

    @ApiModelProperty(value = "id集合")
    private List<String> ids;
}
