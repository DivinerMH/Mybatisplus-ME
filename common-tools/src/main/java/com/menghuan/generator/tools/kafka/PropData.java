package com.menghuan.generator.tools.kafka;

public class PropData {
    public PropData() {

    }
    public PropData(String val) {
        this.val = val;
    }

    private String attrCode;
    //属性名称
    private String attrName;
    //属性ID
    private Integer attrId;
    //属性数据
    private String val;
    //属性数据
    private String isShow;

    public String getAttrCode() {
        return attrCode;
    }


    public String getAttrIdString() {
        return attrId+"";
    }

    public void setAttrCode(String attrCode) {
        this.attrCode=attrCode;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName=attrName;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId=attrId;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val=val;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow=isShow;
    }

}
