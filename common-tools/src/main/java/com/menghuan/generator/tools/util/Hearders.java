package com.menghuan.generator.tools.util;

/**
 * 表头结构对象
 */
public class Hearders {
    /**表头字段名**/
    private String heardField;
    /**是否展示**/
    private boolean viewFlag;
    /**是否编辑**/
    private boolean editFlag;
    /**编辑属性 text redio select checkbox **/
    private String editClass;
    /**字典标识**/
    private String dictType;
    /**是否必填**/
    private boolean required;
    /**默认值**/
    private String val;


    public String getHeardField() {
        return heardField;
    }

    public void setHeardField(String heardField) {
        this.heardField = heardField;
    }

    public boolean isViewFlag() {
        return viewFlag;
    }

    public void setViewFlag(boolean viewFlag) {
        this.viewFlag = viewFlag;
    }

    public boolean isEditFlag() {
        return editFlag;
    }

    public void setEditFlag(boolean editFlag) {
        this.editFlag = editFlag;
    }

    public String getEditClass() {
        return editClass;
    }

    public void setEditClass(String editClass) {
        this.editClass = editClass;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
