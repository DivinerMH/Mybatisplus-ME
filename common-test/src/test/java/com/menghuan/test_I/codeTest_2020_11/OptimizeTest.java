package java.com.menghuan.test_I.codeTest_2020_11;


import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author:menghuan
 * @Date:2020/12/12 11:20
 */
public class OptimizeTest {

    @Test
    public void xxxTest() {
        String str = new String();
        str = "\\xAC\\xED\\x00\\x05t\\x00`{\"alarmDegree\":\"2\",\"insideStatus\":\"f\",\"status\":\"f2\",\"structureId\":20,\"timeMilles\":1607935977093}";
        int i = str.indexOf("{");
        String substring = str.substring(str.indexOf("{"));
        System.out.println(substring);
        JSONObject jsonObject = JSONObject.parseObject(substring);
        String status = jsonObject.getString("status");
        System.out.println(status);
    }

}

