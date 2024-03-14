package com.cateyes.data.govern.bi.bean.dto;

    
    





import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 报表(DgBiReport)ReqQueryDto
 *
 * @author CatEyes
 * @since 2024-01-16 15:41:42
 */
@Data
@ApiModel(value = "报表ReqQueryDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReqBiReportQueryDto extends ReqBaseQueryDto {

                                    @ApiModelProperty(value = "ID")
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
