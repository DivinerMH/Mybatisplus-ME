package com.cateyes.data.govern.datafill.bean.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 动态表单字段池(DgDynamicFieldPool)ReqUpdateDto
 *
 * @author CatEyes
 * @since 2023-11-20 10:50:47
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqDynamicFieldPoolUpdateDto {

    @NotNull(message = "主键ID不可为NULL")
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "字段名称")
    private String fieldName;

    @ApiModelProperty(value = "字段编码")
    private String fieldCode;

    @ApiModelProperty(value = "字段类型")
    private String fieldType;

    @ApiModelProperty(value = "字段长度")
    private Integer fieldLength;

    @ApiModelProperty(value = "是否内置：1、是；2、否；")
    private Integer isInner;

    @ApiModelProperty(value = "是否启用：1、启用；2、禁用；")
    private Integer isDisabled;

}
