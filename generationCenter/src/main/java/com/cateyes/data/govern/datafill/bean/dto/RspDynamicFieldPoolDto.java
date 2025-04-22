package com.cateyes.data.govern.datafill.bean.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 动态表单字段池(DgDynamicFieldPool)RspDto
 *
 * @author CatEyes
 * @since 2023-11-20 10:50:48
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspDynamicFieldPoolDto implements Serializable {

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
