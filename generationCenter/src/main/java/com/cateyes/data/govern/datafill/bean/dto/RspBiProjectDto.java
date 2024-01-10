package com.cateyes.data.govern.datafill.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 项目(DgBiProject)RspDto
 *
 * @author CatEyes
 * @since 2023-12-12 16:05:47
 */
@Data
@ApiModel(value = "项目RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspBiProjectDto implements Serializable {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "项目简介")
    private String projectDesc;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "创建时间")
    private Date createAt;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateAt;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    /*-----------------------------非数据库属性------------------------------*/

}
