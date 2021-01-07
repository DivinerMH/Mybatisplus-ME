package com.helper.kafka;

public class PropData {
    private String attrCode;
    //属性名称
    private String attrName;
    //属性ID
    private Integer attrId;
    //属性数据
    private String val;
    //属性数据
    private String isShow;
    public PropData() {

    }
    public PropData(String val) {
        this.val = val;
    }

    public String getAttrCode() {
        return attrCode;
    }

    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode;
    }

    public String getAttrIdString() {
        return attrId + "";
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

}
