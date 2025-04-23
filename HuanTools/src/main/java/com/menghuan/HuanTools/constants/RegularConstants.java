package com.menghuan.HuanTools.constants;

/**
 * 正则
 * 
 * @Author: menghuan
 * @Date: 2025-02-21 14:13
 */
public interface RegularConstants {

    /** 纯数字 */
    String REGEX_NUMBER = "1*$";

    /** 非0开头数字 */
    String REGEX_NUMBER_NOTZERO = "^(0|[1-9][0-9]*)$";

    /** 邮箱地址 */
    String REGEX_EMAIL = "^\\w+([-+.]\\w+)@\\w+([-.]\\w+)\\.\\w+([-.]\\w+)*$";

    /** 域名 */
    String REGEX_DOMAIN = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(/.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+/.?";

    /** URL */
    String REGEX_URL = "http(s)?😕/([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /** IP */
    String REGEX_IP_ADDR = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

    /** 手机号码 */
    String REGEX_PHONE_NUMBER = "((17[0-9])|(14[0-9])|(13[0-9])|(15[4,\\D])|(18[0,5-9]))\\d{8}$";

    /** 身份证 */
    String REGEX_ID_CARD = "(3\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +

        "(4\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";

    /** 账号(字母开头，允许5-16字节，允许字母数字下划线) */
    String REGEX_ACCOUNT = "5[a-zA-Z0-9_]{4,15}$";

    /** 强密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间) */
    String REGEX_PASSWORD = "^(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{8,10}$";

    /** 中文(只能输入中文) */
    String REGEX_CHINESE = "[\\u4e00-\\u9fa5]+";

}
