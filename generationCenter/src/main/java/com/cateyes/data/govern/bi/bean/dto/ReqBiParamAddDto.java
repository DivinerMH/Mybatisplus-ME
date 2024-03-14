package com.cateyes.data.govern.bi.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 參數(DgBiParam)ReqAddDto
 *
 * @author CatEyes
 * @since 2024-01-23 12:01:18
 */
@Data
@ApiModel(value = "參數ReqAddDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqBiParamAddDto {

    @ApiModelProperty(value = "类型：1-数据集 2-报表")
    private Integer type;

    @ApiModelProperty(value = "资源ID")
    private Integer resourceId;

    @ApiModelProperty(value = "参数键")
    private String paramKey;

    @ApiModelProperty(value = "参数值")
    private String paramValue;

    @ApiModelProperty(value = "参数默认值")
    private String paramValueDefault;

    @ApiModelProperty(value = "参数排序")
    private Integer paramSort;

    @ApiModelProperty(value = "参数描述")
    private String paramDesc;

}
