package com.cateyes.smart.park.invest.bean.dto;

    
    






import com.cateyes.smart.park.base.bean.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 产业-产业环节-产业节点信息表(SpIndustry)ReqDto
 *
 * @author CatEyes
 * @since 2023-04-19 14:23:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqIndustryDto extends BaseDto {

    @ApiModelProperty(value = "产业")
    private Integer id;
    
    @ApiModelProperty(value = "父节点")
    private Integer parent;
    
    @ApiModelProperty(value = "名称")
    private String name;
    
    @ApiModelProperty(value = "介绍")
    private String info;
    
    @ApiModelProperty(value = "当前节点path路径")
    private String path;
    
    @ApiModelProperty(value = "是否主导产业")
    private Boolean isLead;
    

}
