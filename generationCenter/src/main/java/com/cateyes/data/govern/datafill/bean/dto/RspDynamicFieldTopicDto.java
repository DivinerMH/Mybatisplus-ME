package com.cateyes.data.govern.datafill.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 动态表单字段主题(DgDynamicFieldTopic)RspDto
 *
 * @author CatEyes
 * @since 2023-12-05 09:30:06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspDynamicFieldTopicDto implements Serializable {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "主题名称")
    private String topicName;

    @ApiModelProperty(value = "主题排序")
    private Integer topicOrder;

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
