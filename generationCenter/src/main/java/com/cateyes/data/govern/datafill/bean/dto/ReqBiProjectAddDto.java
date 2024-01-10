package com.cateyes.data.govern.datafill.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目(DgBiProject)ReqAddDto
 *
 * @author CatEyes
 * @since 2023-12-12 16:05:46
 */
@Data
@ApiModel(value = "项目ReqAddDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqBiProjectAddDto {

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "项目简介")
    private String projectDesc;

    @ApiModelProperty(value = "排序")
    private Integer sort;

}
