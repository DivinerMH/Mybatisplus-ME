package com.cateyes.smart.park.bean.dto;

    
    





import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (SpIotDeviceType)RspDto
 *
 * @author CatEyes
 * @since 2023-05-19 15:32:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspDeviceTypeDto implements Serializable {

    @ApiModelProperty(value = "")
    private Integer id;
    
    @ApiModelProperty(value = "园区ID")
    private Integer parkId;
    
    @ApiModelProperty(value = "父级ID")
    private Integer parentId;
    
    @ApiModelProperty(value = "类别名称")
    private String typeName;
    
    @ApiModelProperty(value = "类别状态：1-启用；2-禁用；")
    private Integer isDisabled;
    
    @ApiModelProperty(value = "创建时间")
    private Date createAt;
    
    @ApiModelProperty(value = "创建人")
    private String createBy;
    

}
