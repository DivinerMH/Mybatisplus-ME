package com.menghuan.HuanTools.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yinjie
 * @version 1.0
 * @ClassName: UnicodeCleanDict
 * @description: Unicode 控制字符字典
 * 用于定义需要被清理的 Unicode 字符及其描述
 * @date 2026/3/13 17:47
 */
@Getter
public enum UnicodeCleanDict {

    ZERO_WIDTH_SPACE("\u200B", "零宽空格"),
    ZERO_WIDTH_NON_JOINER("\u200C", "零宽非连接符"),
    ZERO_WIDTH_JOINER("\u200D", "零宽连接符"),
    BYTE_ORDER_MARK("\uFEFF", "字节顺序标记/零宽不换行空格"),
    LEFT_TO_RIGHT_MARK("\u200E", "从左到右标记"),
    RIGHT_TO_LEFT_MARK("\u200F", "从右到左标记"),
    LINE_SEPARATOR("\u2028", "行分隔符"),
    PARAGRAPH_SEPARATOR("\u2029", "段落分隔符"),
    NARROW_NO_BREAK_SPACE("\u202F", "窄不换行空格"),
    MEDIUM_MATHEMATICAL_SPACE("\u205F", "中等数学空格"),
    IDEOGRAPHIC_SPACE("\u3000", "表意文字空格"),
    ;

    private final String unicode;
    private final String description;

    UnicodeCleanDict(String unicode, String description) {
        this.unicode = unicode;
        this.description = description;
    }

    /**
     * 获取所有需要清理的 Unicode 字符正则表达式
     */
    public static String getCleanRegex() {
        StringBuilder regex = new StringBuilder("[");
        for (UnicodeCleanDict dict : values()) {
            regex.append(dict.getUnicode());
        }
        regex.append("]");
        return regex.toString();
    }

    /**
     * 获取所有需要清理的字符列表（带描述）
     */
    public static Map<String, String> getCleanCharsWithDesc() {
        Map<String, String> charMap = new HashMap<>();
        for (UnicodeCleanDict dict : values()) {
            charMap.put(dict.getUnicode(), dict.getDescription());
        }
        return charMap;
    }

    /**
     * 判断字符是否为特殊字符
     */
    public static boolean isSpecialChar(char c) {
        // 定义特殊字符的范围
        return (c >= '\u2000' && c <= '\u206F') ||  // 通用标点符号
               (c >= '\u3000' && c <= '\u303F') ||  // CJK 符号和标点
               c == '\uFEFF';                        // 字节顺序标记
    }

    /**
     * 获取特殊字符的描述
     */
    public static String getSpecialCharDescription(char c) {
        for (UnicodeCleanDict dict : values()) {
            if (dict.getUnicode().charAt(0) == c) {
                return dict.getDescription();
            }
        }
        return "未登记的特殊字符";
    }

    /**
     * 检查字符是否已在字典中登记
     */
    public static boolean containsChar(char c) {
        for (UnicodeCleanDict dict : values()) {
            if (dict.getUnicode().charAt(0) == c) {
                return true;
            }
        }
        return false;
    }
}
