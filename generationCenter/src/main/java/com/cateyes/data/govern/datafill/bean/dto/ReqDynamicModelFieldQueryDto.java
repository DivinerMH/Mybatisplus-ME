package com.cateyes.data.govern.datafill.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 动态表单字段(DgDynamicModelField)ReqQueryDto
 *
 * @author CatEyes
 * @since 2023-11-20 13:56:08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReqDynamicModelFieldQueryDto extends ReqBaseQueryDto {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "模型ID")
    private Integer modelId;

    @ApiModelProperty(value = "字段名称")
    private String fieldName;

    @ApiModelProperty(value = "字段编码")
    private String fieldCode;

    @ApiModelProperty(value = "字段类型")
    private String fieldType;

    @ApiModelProperty(value = "字段长度")
    private Integer fieldLength;

    @ApiModelProperty(value = "字段顺序")
    private Integer fieldOrder;

}
