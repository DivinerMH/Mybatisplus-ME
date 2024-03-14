package com.cateyes.data.govern.bi.bean.dto;

    
    





import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 报表(DgBiReport)RspDto
 *
 * @author CatEyes
 * @since 2024-01-16 15:41:42
 */
@Data
@ApiModel(value = "报表RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspBiReportDto implements Serializable {

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
