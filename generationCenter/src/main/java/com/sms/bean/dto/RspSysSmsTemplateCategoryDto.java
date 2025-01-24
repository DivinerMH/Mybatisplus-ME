package com.sms.bean.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短信模板分类(SysSmsTemplateCategory)RspDto
 *
 * @author makejava
 * @since 2025-01-15 15:47:55
 */
@Data
@ApiModel(value = "短信模板分类RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspSysSmsTemplateCategoryDto implements Serializable {

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

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;

    @ApiModelProperty(value = "组织机构")
    private String orgCode;

    /*-----------------------------非数据库属性------------------------------*/

}
