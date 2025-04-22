package com.cateyes.data.govern.datafill.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.mybatis.MetaData;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 动态表单字段主题(DgDynamicFieldTopic)Po
 *
 * @author CatEyes
 * @since 2023-12-05 09:30:03
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("dg_dynamic_field_topic")
public class DynamicFieldTopic extends MetaData {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "主题名称")
    private String topicName;

    @ApiModelProperty(value = "主题排序")
    private Integer topicOrder;

}
