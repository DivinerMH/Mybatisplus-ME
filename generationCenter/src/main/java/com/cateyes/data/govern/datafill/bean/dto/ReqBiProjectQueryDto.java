package com.cateyes.data.govern.datafill.bean.dto;

import com.cateyes.base.dto.ReqBaseQueryDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 项目(DgBiProject)ReqQueryDto
 *
 * @author CatEyes
 * @since 2023-12-12 16:05:47
 */
@Data
@ApiModel(value = "项目ReqQueryDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReqBiProjectQueryDto extends ReqBaseQueryDto {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "项目简介")
    private String projectDesc;

    @ApiModelProperty(value = "排序")
    private Integer sort;

}
