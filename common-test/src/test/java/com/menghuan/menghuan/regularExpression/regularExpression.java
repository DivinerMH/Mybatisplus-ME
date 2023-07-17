package java.com.menghuan.menghuan.regularExpression;


import org.junit.jupiter.api.Test;
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



}
