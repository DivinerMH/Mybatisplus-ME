package com.sms.bean.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 短信模板分类(SysSmsTemplateCategory)ReqQueryDto
 *
 * @author makejava
 * @since 2025-01-15 15:47:54
 */
@Data
@ApiModel(value = "短信模板分类ReqQueryDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReqSysSmsTemplateCategoryQueryDto extends ReqBaseQueryDto {

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

    @ApiModelProperty(value = "id集合")
    private List<String> ids;
}
