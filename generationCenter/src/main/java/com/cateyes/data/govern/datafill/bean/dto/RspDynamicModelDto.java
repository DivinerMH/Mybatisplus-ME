package com.cateyes.data.govern.datafill.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 动态表单模型(DgDynamicModel)RspDto
 *
 * @author CatEyes
 * @since 2023-11-20 13:55:43
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspDynamicModelDto implements Serializable {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "模型名称")
    private String modelName;

    @ApiModelProperty(value = "模型编码")
    private String modelCode;

    @ApiModelProperty(value = "模型介绍")
    private String modelDesc;

    @ApiModelProperty(value = "启用状态：1-启用；2-禁用；")
    private Integer isDisabled;

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
