package com.cateyes.data.govern.datafill.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 动态表单字段(DgDynamicModelField)RspDto
 *
 * @author CatEyes
 * @since 2023-11-20 13:56:08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspDynamicModelFieldDto implements Serializable {

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
