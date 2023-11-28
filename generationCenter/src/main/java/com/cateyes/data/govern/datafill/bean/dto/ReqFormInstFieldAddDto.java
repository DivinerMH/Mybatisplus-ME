package com.cateyes.data.govern.datafill.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表单实例数据(DgFormInstField)ReqAddDto
 *
 * @author CatEyes
 * @since 2023-11-21 10:16:34
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqFormInstFieldAddDto {

    @ApiModelProperty(value = "实例ID")
    private Integer formInstId;

    @ApiModelProperty(value = "模型ID")
    private Integer modelId;

    @ApiModelProperty(value = "字段ID")
    private Integer fieldId;

    @ApiModelProperty(value = "字段值")
    private String fieldValue;

}
