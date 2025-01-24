package com.helper.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.helper.constant.ConditionConstants;

/**
 * 条件比对的方法类
 *
 * @author Administrator
 * @version Id: ConditionUtils, v 0.1 2020\2\12 0012 15:43 Administrator Exp $$
 **/
public class ConditionUtils {

    /**
     * 得到比较结果的方法
     *
     * @param upsteamValye
     * @param contrastValue
     * @return
     */
    public static int comparable(String upsteamValye, String contrastValue) {
        try {
            return ((Comparable) getCaseData(upsteamValye)).compareTo(getCaseData(contrastValue));
        } catch (Exception e) {
            Class<String> clz = String.class;
            return ((Comparable) getCaseData(upsteamValye, clz)).compareTo(getCaseData(contrastValue, clz));
        }
    }

    /**
     * 数据比对的方法
     * 因为不明确进来的比较值是什么类型所以使用 comparable 接口以obj类型进行比较
     * 根据业务将数据抽象为三种类型   string   date  double 设定double类型是为了同时对int数据进行兼容
     * 比较符号
     * 比较值
     * 判断值
     *
     * @return
     */
    public static Boolean conditionComparison(Boolean flag, int condition, String upsteamValye, String contrastValue) {
        if (StringUtils.isEmpty(upsteamValye)) {
            return false;
        }
        //将对比的结果拿进去和比较符号进行判定看是否满足
        int ret = comparable(upsteamValye, contrastValue);// -1 小于  0 等于  大于
        switch (condition) {
            case ConditionConstants.EQU:
                flag = eq(ret);
                break;
            case ConditionConstants.GTR:
                flag = gtr(ret);
                break;
            case ConditionConstants.GEQ:
                flag = geq(ret);
                break;
            case ConditionConstants.LSS:
                flag = lss(ret);
                break;
            case ConditionConstants.LEQ:
                flag = leq(ret);
                break;
            case ConditionConstants.NEQ:
                flag = neq(ret);
                break;
            default:
                flag = false;
        }

        return flag;
    }


    /**
     * 转型方法
     *
     * @param input 不符合条件的全部认为 String
     * @param <T>
     * @return
     * @throws ParseException
     */
    public static <T> T getCaseData(String input) throws ParseException {
        if (input.matches("^[0-9]+$") || input.matches("^[0-9]+([.]{0,1}[0-9]+){0,1}$")) {
            Class<T> clz = (Class<T>) Double.class;
            return clz.cast(Double.parseDouble(input));
        } else if (input.matches("([0-1]\\d|2[0-3]):[0-5]\\d:[0-5]\\d")) {
            Class<T> clz = (Class<T>) Date.class;
            return clz.cast(DateUtils.parseTimeToDate(input));
        } else {
            Class<T> clz = (Class<T>) String.class;
            return clz.cast(input);
        }
    }

    public static <T> T getCaseData(String input, Class<T> clz) {
        return clz.cast(input);
    }


    /**
     * 等于
     *
     * @param ret
     * @return
     */
    public static Boolean eq(int ret) {
        if (ret == 0) {
            return true;
        } else {
            return false;
        }
    }


    public static Boolean gtr(int ret) {
        if (ret == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean geq(int ret) {
        if (ret == 0 || ret == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean lss(int ret) {
        if (ret == -1 || ret == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean leq(int ret) {
        if (ret == -1 || ret == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean neq(int ret) {
        if (ret != 0) {
            return true;
        } else {
            return false;
        }
    }


}
