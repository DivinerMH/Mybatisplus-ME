package com.cateyes.data.govern.datafill.bean.dto;

    
    





import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 动态表单字段池主题关联(DgDynamicFieldPoolTopic)ReqQueryDto
 *
 * @author CatEyes
 * @since 2023-12-04 19:36:11
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReqDynamicFieldPoolTopicQueryDto extends ReqBaseQueryDto {


                    @ApiModelProperty(value = "主键")
        private Integer id;
            

            @ApiModelProperty(value = "字段主题ID")
        private Integer topicId;
            

            @ApiModelProperty(value = "字段池ID")
        private Integer poolId;
            


}
