package po;

    
    


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 招商线索列表(SpInvestmentLead)表实体类
 *
 * @author menghuan
 * @since 2023-04-03 20:39:19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpInvestmentLead implements Serializable  {


    
            @TableId(value = "id", type = IdType.AUTO)
        @ApiModelProperty(value = "主键id")
        private Integer id;
        
            @ApiModelProperty(value = "名称")
        private String name;
        
            @ApiModelProperty(value = "线索编码")
        private String serialNumber;
        
            @ApiModelProperty(value = "联系人")
        private String contactPerson;
        
            @ApiModelProperty(value = "联系电话")
        private String contactTel;
        
            @ApiModelProperty(value = "线索来源")
        private Integer fromType;
        
            @ApiModelProperty(value = "渠道类型")
        private Integer wayType;
        
            @ApiModelProperty(value = "最近跟踪人")
        private Integer followBy;
        
            @ApiModelProperty(value = "创建人",fill = FieldFill.INSERT )
        private Integer createBy;
        
            @ApiModelProperty(value = "创建时间",fill = FieldFill.INSERT )
        private Date createTime;
    
}
