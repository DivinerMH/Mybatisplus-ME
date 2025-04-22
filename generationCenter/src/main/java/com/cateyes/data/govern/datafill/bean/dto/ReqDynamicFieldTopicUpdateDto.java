package com.cateyes.data.govern.datafill.bean.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 动态表单字段主题(DgDynamicFieldTopic)ReqUpdateDto
 *
 * @author CatEyes
 * @since 2023-12-05 09:30:05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqDynamicFieldTopicUpdateDto {

    @NotNull(message = "主键ID不可为NULL")
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "主题名称")
    private String topicName;

    @ApiModelProperty(value = "主题排序")
    private Integer topicOrder;

}
