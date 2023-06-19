package com.menghuan.regularExpression;

/**
 * 正则常量
 *      1、注意 // 转移字符
 *      2、正则公式编写地址：https://regexper.com/
 *      3、验证地址：http://www.jsons.cn/reg/
 * @Author: menghuan
 * @Date: 2022/7/15 17:22
 */
public interface RegularConstants {

    // 纯数字
    String REGEX_NUMBER = "1*$";

    // 非0开头数字
    String REGEX_NUMBER_NOTZERO = "^(0|[1-9][0-9]*)$";

    // 邮箱地址
    String REGEX_EMAIL = "^\\w+([-+.]\\w+)@\\w+([-.]\\w+)\\.\\w+([-.]\\w+)*$";

    // 域名
    String REGEX_DOMAIN = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(/.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+/.?";

    // URL
    String REGEX_URL = "http(s)?😕/([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    // IP
    String REGEX_IP_ADDR = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

    // 手机号码
    String REGEX_PHONE_NUMBER = "((17[0-9])|(14[0-9])|(13[0-9])|(15[4,\\D])|(18[0,5-9]))\\d{8}$";

    // 2[2,3,4,5,6,7,8,9][0-9]{9}$"手机号码这个要特别注意，根据时间推移可能会开放新号码段

    // 身份证
    String REGEX_ID_CARD = "(3\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +

            "(4\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";

    // 校验18位二代身份证
    String REGEX_ID_CARD_LONG = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";

    // 账号(字母开头，允许5-16字节，允许字母数字下划线)
    String REGEX_ACCOUNT = "5[a-zA-Z0-9_]{4,15}$";

    // 强密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间)
    String REGEX_PASSWORD = "^(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{8,10}$";

    // 中文 、汉字(只能输入中文)
    String REGEX_CHINESE = "[\\u4e00-\\u9fa5]+";

    // 字母和数字
    String REGEX_LETTERS_NUMBERS = "[a-zA-Z0-9]+";

    // 不允许出现特殊字符#
    String REGEX_SPECIAL_CHARACTER = "[^#]+";

    // 以xxx开头(中间内容不管)以xxx结尾
    String REGEX_START_END = "^\\d.*\\d$";

    // 以"-"开头(中间内容不管)以"-"结尾 (示例 Path ： "-0-21-127-654-1024-")
    String REGEX_START_NUM_END_NUM = "^-\\S*?-$";


}
