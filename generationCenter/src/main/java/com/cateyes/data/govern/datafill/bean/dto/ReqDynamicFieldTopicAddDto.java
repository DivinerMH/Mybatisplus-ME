package com.cateyes.data.govern.datafill.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 动态表单字段主题(DgDynamicFieldTopic)ReqAddDto
 *
 * @author CatEyes
 * @since 2023-12-05 09:30:04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqDynamicFieldTopicAddDto {

    @ApiModelProperty(value = "主题名称")
    private String topicName;

    @ApiModelProperty(value = "主题排序")
    private Integer topicOrder;

}
