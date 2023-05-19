package com.cateyes.smart.park.bean.dto;

    
    





import com.cateyes.smart.park.base.bean.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (SpIotDeviceType)ReqDto
 *
 * @author CatEyes
 * @since 2023-05-19 15:32:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqDeviceTypeDto extends BaseDto {

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
