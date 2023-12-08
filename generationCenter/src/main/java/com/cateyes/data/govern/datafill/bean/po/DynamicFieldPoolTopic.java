package com.cateyes.data.govern.datafill.bean.po;

    
    






import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 动态表单字段池主题关联(DgDynamicFieldPoolTopic)Po
 *
 * @author CatEyes
 * @since 2023-12-04 19:36:11
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("dg_dynamic_field_pool_topic")
public class DynamicFieldPoolTopic extends MetaData {



                    @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
    
            @ApiModelProperty(value = "字段主题ID")
                private Integer topicId;
    
            @ApiModelProperty(value = "字段池ID")
                private Integer poolId;
    
}
