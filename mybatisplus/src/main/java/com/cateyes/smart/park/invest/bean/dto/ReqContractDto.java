package com.cateyes.smart.park.invest.bean.dto;

import com.cateyes.smart.park.base.bean.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 合同基本信息表(SpContract)ReqDto
 *
 * @author CatEyes
 * @since 2023-05-08 10:07:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqContractDto extends BaseDto {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "园区id")
    private Integer parkId;

    @ApiModelProperty(value = "企业id")
    private Integer companyId;

    @ApiModelProperty(value = "合同类型：0-厂房/办公楼租赁 1-厂房/办公楼购买 2-土地租赁 3-土地购买")
    private Integer type;

    @ApiModelProperty(value = "合同名称")
    private String name;

    @ApiModelProperty(value = "合同编号")
    private String serialNumber;

    @ApiModelProperty(value = "状态：0-未提交 1-提交 2-审核中 3-通过 4-驳回 5-撤销 6-已归档")
    private Integer state;

    @ApiModelProperty(value = "合同文件id，多个以,分割")
    private String fileId;

    @ApiModelProperty(value = "签章合同文件id，多个以,分割")
    private String fileSignedId;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "归档时间")
    private Date filingTime;

}
