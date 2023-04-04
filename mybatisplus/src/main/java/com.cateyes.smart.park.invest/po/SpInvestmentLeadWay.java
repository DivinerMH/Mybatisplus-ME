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
 * 来源渠道表(SpInvestmentLeadWay)表实体类
 *
 * @author menghuan
 * @since 2023-04-04 09:51:13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpInvestmentLeadWay implements Serializable  {


    
            @TableId(value = "id", type = IdType.AUTO)
        @ApiModelProperty(value = "")
        private Integer id;
        
            @ApiModelProperty(value = "名称")
        private String name;
        
            @ApiModelProperty(value = "1-线索来源；2-线索渠道")
        private Integer type;
        
            @ApiModelProperty(value = "启用")
        private Integer enable;
        
            @ApiModelProperty(value = "创建人",fill = FieldFill.INSERT )
        private Integer createBy;
        
            @ApiModelProperty(value = "创建时间",fill = FieldFill.INSERT )
        private Date createTime;
    
}
