package com.cateyes.smart.park.invest.bean.dto;

    
    






import com.cateyes.smart.park.base.bean.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 企业库表(SpCompany)ReqDto
 *
 * @author CatEyes
 * @since 2023-05-08 10:40:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqCompanyDto extends BaseDto {

    @ApiModelProperty(value = "主键id")
    private Integer id;
    
    @ApiModelProperty(value = "园区id")
    private Integer parkId;
    
    @ApiModelProperty(value = "企业名称")
    private String name;
    
    @ApiModelProperty(value = "企业类型：0-园区外企业 1-意向企业 2-在谈企业 3-入驻企业")
    private Integer type;
    
    @ApiModelProperty(value = "联系人")
    private String contactPerson;
    
    @ApiModelProperty(value = "联系人电话")
    private String contactTel;
    
    @ApiModelProperty(value = "企业官网地址")
    private String companyUrl;
    
    @ApiModelProperty(value = "企业地址")
    private String companyAddress;
    
    @ApiModelProperty(value = "企业邮箱")
    private String email;
    
    @ApiModelProperty(value = "传真")
    private String fax;
    
    @ApiModelProperty(value = "行业id")
    private Integer tradeId;
    
    @ApiModelProperty(value = "产业id")
    private Integer industry;
    
    @ApiModelProperty(value = "产业环节")
    private Integer industrySecond;
    
    @ApiModelProperty(value = "产业节点")
    private Integer industryNode;
    
    @ApiModelProperty(value = "土地面积")
    private BigDecimal landArea;
    
    @ApiModelProperty(value = "办公面积")
    private BigDecimal buildingArea;
    
    @ApiModelProperty(value = "是否购买（租赁）：0-false 1-true")
    private Boolean isBuy;
    
    @ApiModelProperty(value = "渠道id")
    private Integer wayChannelId;
    
    @ApiModelProperty(value = "线索id")
    private Integer wayClueId;
    
    @ApiModelProperty(value = "企业规模：0-50人以下 1-50-100人以下 2-100-500人 3-500-1000人 4-1000人以上")
    private Integer scale;
    
    @ApiModelProperty(value = "企业资质-位运算：0-科技型中小企业 1-国家高新技术企业 2-专精特新企业 3-国家“小巨人”企业")
    private Integer qualification;
    
    @ApiModelProperty(value = "企业阶段：0-初创阶段 1-成长阶段 2-成熟阶段 3-衰退阶段")
    private Integer stage;
    
    @ApiModelProperty(value = "是否是归链企业：0-false 1-true")
    private Boolean glType;
    
    @ApiModelProperty(value = "是否重点企业：0-false 1-true")
    private Boolean isKey;
    
    @ApiModelProperty(value = "是否上市企业：0-false 1-true")
    private Boolean isIpo;
    
    @ApiModelProperty(value = "是否规上企业：0-false 1-true")
    private Boolean isScaleAbove;
    
    @ApiModelProperty(value = "上规日期")
    private Date scaleAboveDate;
    
    @ApiModelProperty(value = "企业LOGO")
    private String logoFileId;
    
    @ApiModelProperty(value = "企业图片")
    private String picFileId;
    
    @ApiModelProperty(value = "企业简介")
    private String info;
    
    @ApiModelProperty(value = "经度")
    private String longitude;
    
    @ApiModelProperty(value = "纬度")
    private String latitude;
    
    @ApiModelProperty(value = "跟进人")
    private Integer follow;
    
    @ApiModelProperty(value = "创建人")
    private Integer createBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    
    @ApiModelProperty(value = "更新人")
    private Integer updateBy;
    
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    

}
