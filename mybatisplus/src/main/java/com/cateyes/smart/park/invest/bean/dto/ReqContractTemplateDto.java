package com.cateyes.smart.park.invest.bean.dto;

    
    






import com.cateyes.smart.park.base.bean.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 合同模板表(SpContractTemplate)ReqDto
 *
 * @author CatEyes
 * @since 2023-05-08 10:04:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqContractTemplateDto extends BaseDto {

    @ApiModelProperty(value = "主键id")
    private Integer id;
    
    @ApiModelProperty(value = "园区id")
    private Integer parkId;
    
    @ApiModelProperty(value = "合同模板名称")
    private String name;
    
    @ApiModelProperty(value = "文件id")
    private String fileId;
    
    @ApiModelProperty(value = "创建人")
    private Integer createBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    

}
