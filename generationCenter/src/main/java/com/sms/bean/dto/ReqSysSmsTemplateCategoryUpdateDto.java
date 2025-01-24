package com.sms.bean.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短信模板分类(SysSmsTemplateCategory)ReqUpdateDto
 *
 * @author makejava
 * @since 2025-01-15 15:47:54
 */
@Data
@ApiModel(value = "短信模板分类ReqUpdateDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqSysSmsTemplateCategoryUpdateDto {

    @NotBlank(message = "主键ID不可为空")
    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "删除标记")
    private Integer delFlag;

    @ApiModelProperty(value = "组织机构")
    private String orgCode;

}
