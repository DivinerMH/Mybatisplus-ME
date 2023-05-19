package com.cateyes.smart.park.invest.bean.dto;

    
    





import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (SpIotCameraEventType)RspDto
 *
 * @author CatEyes
 * @since 2023-05-19 15:20:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspCameraEventTypeDto implements Serializable {

    @ApiModelProperty(value = "")
    private Integer id;
    
    @ApiModelProperty(value = "事件类型")
    private Integer eventType;
    
    @ApiModelProperty(value = "事件名称")
    private String eventName;
    

}
