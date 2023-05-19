package com.cateyes.smart.park.invest.bean.dto;

    
    





import com.cateyes.smart.park.base.bean.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (SpIotCameraEventType)ReqDto
 *
 * @author CatEyes
 * @since 2023-05-19 15:20:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqCameraEventTypeDto extends BaseDto {

    @ApiModelProperty(value = "")
    private Integer id;
    
    @ApiModelProperty(value = "事件类型")
    private Integer eventType;
    
    @ApiModelProperty(value = "事件名称")
    private String eventName;

    @ApiModelProperty(value = "事件名称")
    private String Name;
    

}
