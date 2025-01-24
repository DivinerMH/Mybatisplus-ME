package com.menghuan.regularExpression;

import java.util.regex.Pattern;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @Author: menghuan
 * @Date: 2022/7/15 16:14
 */
public class regularExpression {


    @Test
    public void testRegularExpression() {
        String str = "kksadjosanofdbsa";
        Assert.notNull(str, "参数不能为空");

        Boolean match = RegularMatchUtils.match(RegularConstants.REGEX_NUMBER, str);
        System.out.println("Boolean：" + match);

        Assert.isNull(str, "参数不为空");

        System.out.println("断言");
    }

    @Test
    public void testRegularExpression2() {
        // String str = "kksadjosanofdbsagai";
        // String str = "kksadjosanofdbsagai222222";
        String str = "-kk-";
        String str2 = "-kkaapp9090-";
        String str3 = "-kk";
        String str4 = "kk-";
        String str5 = "--";
        String str6 = "a-kk-";
        Boolean match = RegularMatchUtils.match(RegularConstants.REGEX_START_NUM_END_NUM, str6);
        System.out.println("Boolean：" + match);
        // System.out.println("断言");
    }



    private static final String FUZZY_QUERY_RULE = "^#\\S*?#$";

    private static String paramDealFuzzyQuery(String param) {
        /*boolean param1 = RegularMatchUtils.match(FUZZY_QUERY_RULE, "param");
        if (param1) {
            String substring = param.substring(1, param.length() - 1);
            return substring;
        } else {
            return param;
        }*/
        return Pattern.matches(FUZZY_QUERY_RULE, "param") ? param.substring(1, param.length() - 1) : param;
    }

    private static final String FUZZY_QUERY_RULE_2 = "^#.*?#$"; // 允许中间包含空白字符

    public static String paramDealFuzzyQuery_2(String param) {
        if (Pattern.matches(FUZZY_QUERY_RULE, param)) {
            // 检查长度以避免 StringIndexOutOfBoundsException
            if (param.length() > 2) {
                String substring = param.substring(1, param.length() - 1);
                return substring;
            } else {
                // 理论上这种情况不会发生，因为正则表达式要求至少有一个非 # 字符在中间
                // 但为了代码的健壮性，我们还是处理一下这种情况
                return "";
            }
        } else {
            return param;
        }
    }

    public static void main(String[] args) {
        System.out.println(paramDealFuzzyQuery_2("#333"));
        System.out.println(paramDealFuzzyQuery_2("333#"));
        System.out.println(paramDealFuzzyQuery_2("##"));
        System.out.println(paramDealFuzzyQuery_2("#ZZZ#"));
    }

}
