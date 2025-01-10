package com.cateyes.data.govern.bi.bean.po;

    
    






import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import com.base.mybatis.MetaData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


/**
 * 报表(DgBiReport)Po
 *
 * @author CatEyes
 * @since 2024-01-16 15:41:42
 */
@Data
@ApiModel(value = "报表Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("dg_bi_report")
public class BiReport extends MetaData {

        
                                    @TableId(value = "id", type = IdType.AUTO)
            private Integer id;
                
                        @ApiModelProperty(value = "项目ID（筛选）")
                        private Integer projectId;
                
                        @ApiModelProperty(value = "数据源ID")
                        private Integer datasourceId;
                
                        @ApiModelProperty(value = "报表名称")
                        private String reportName;
                
                        @ApiModelProperty(value = "报表SQL")
                        private String reportSql;
                
                        @ApiModelProperty(value = "报表描述")
                        private String reportDesc;
                
                        @ApiModelProperty(value = "报表字段")
                        private String reportField;
                
                        @ApiModelProperty(value = "")
                        private Integer isDisabled;
                
                                                                
                                                                
                                                                
                                                                
        
}
