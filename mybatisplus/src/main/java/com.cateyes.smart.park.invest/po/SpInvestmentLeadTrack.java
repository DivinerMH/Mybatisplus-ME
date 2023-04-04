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
 * 招商线索跟踪信息表(SpInvestmentLeadTrack)表实体类
 *
 * @author menghuan
 * @since 2023-04-03 20:43:14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpInvestmentLeadTrack implements Serializable  {


    
            @TableId(value = "id", type = IdType.AUTO)
        @ApiModelProperty(value = "")
        private Integer id;
        
            @ApiModelProperty(value = "线索id")
        private Integer investmentLeadId;
        
            @ApiModelProperty(value = "跟踪人")
        private Integer follower;
        
            @ApiModelProperty(value = "跟进记录")
        private String record;
        
            @ApiModelProperty(value = "跟进时间")
        private Date time;
    
}
