package com.menghuan.HuanTools.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * 文件类型
 * @author diviner
 */
public enum FileTypeEnum {

    /**
     * 文档类型（folder:文件夹 excel:excel doc:word pp:ppt image:图片  archive:其他文档 video:视频）
     */
    XLS(".xls","excel","excel"),
    XLSX(".xlsx","excel","excel"),
    DOC(".doc","doc","word"),
    DOCX(".docx","doc","word"),
    PPT(".ppt","pp","ppt"),
    PPTX(".pptx","pp","ppt"),
    GIF(".gif","image","图片"),
    JPG(".jpg","image","图片"),
    JPEG(".jpeg","image","图片"),
    PNG(".png","image","图片"),
    TXT(".txt","text","文本"),
    AVI(".avi","video","视频"),
    MOV(".mov","video","视频"),
    RMVB(".rmvb","video","视频"),
    RM(".rm","video","视频"),
    FLV(".flv","video","视频"),
    MP4(".mp4","video","视频"),
    ZIP(".zip","zip","压缩包"),
    PDF(".pdf","pdf","pdf");

    private String type;
    private String value;
    private String text;

    private FileTypeEnum(String type, String value, String text){
        this.type = type;
        this.value = value;
        this.text = text;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static FileTypeEnum getByType(String type){
        if (StringUtils.isBlank(type)) {
            return null;
        }
        for (FileTypeEnum val : values()) {
            if (val.getType().equals(type)) {
                return val;
            }
        }
        return null;
    }

}
