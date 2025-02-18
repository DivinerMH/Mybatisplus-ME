package com.menghuan.HuanTools.constants;

/**
 * 通用常量
 *
 * @author menghuan
 * @date 2025-02-18
 */
public interface Cst {

    /** 成功标记 */
    Integer SUCCESS = 1;

    /** 失败标记 */
    Integer FAIL = 0;

    /** 成功标记 */
    Boolean TRUE = true;

    /** 失败标记 */
    Boolean FALSE = false;

    /*----------------------------------------------- 系统级 - 通用常量 ----------------------------------------------*/

    /**
     * 数字常量 0~10
     */
    interface FigureConstants {
        /** Integer 类型数字常量 0~10 */
        Integer ZERO_INT = 0;
        Integer ONE_INT = 1;
        Integer TWO_INT = 2;
        Integer THREE_INT = 3;
        Integer FOUR_INT = 4;
        Integer FIVE_INT = 5;
        Integer SIX_INT = 6;
        Integer SEVEN_INT = 7;
        Integer EIGHT_INT = 8;
        Integer NINE_INT = 9;
        Integer TEN_INT = 10;

        /** String 类型数字常量 0~10 */
        String ZERO = "0";
        String ONE = "1";
        String TWO = "2";
        String THREE = "3";
        String FOUR = "4";
        String FIVE = "5";
        String SIX = "6";
        String SEVEN = "7";
        String EIGHT = "8";
        String NINE = "9";
        String TEN = "10";
    }

}
