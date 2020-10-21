package com.menghuan.generator.tools.util;

import io.swagger.annotations.ApiModelProperty;

/**
 * 基类
 */
public class BaseEntity{

    @ApiModelProperty(value="每页大小",name="interfacePath",example = "10",required=false)
    private String limit;
    @ApiModelProperty(value="页码起止",name="interfacePath",example = "0",required=false)
    private String offset;


    @ApiModelProperty(value="字典翻译值 value 无需填写仅供读取",name="value",required=false)
    private String value;
    @ApiModelProperty(value="字典翻译值 label 无需填写仅供读取",name="label",required=false)
    private String label;


    private Integer structureId;

    private Integer tenantId ;

    public Integer getTenantId() {
        return tenantId != null? tenantId:0;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId != null? tenantId:0;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getStructureId() {
        return structureId;
    }

    public void setStructureId(Integer structureId) {
        this.structureId = structureId;
    }
}
