package com.menghuan.Groovy;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: menghuan
 * @Date: 2021/12/27 16:48
 */
@Slf4j
public class GroovyTest {

    static {
        Map<String, String> map = new HashMap<String, String>();

        String param = "{\"a\":\"5.00\",\"b\":\"13\",\"c\":\"27\"}";
        String code = "import com.alibaba.fastjson.JSON;def toDo(vv){def dd = null;vv = vv.split(\";\");String a=vv[0];Map<String,String>map=JSON.parseObject(a);BigDecimal num1=new BigDecimal(map.get(\"a\"));BigDecimal num2=new BigDecimal(map.get(\"b\"));try{result=num1.multiply(num2);dd=result;}catch(Exception e){dd=0;}\n" +
                "                                              return \"$dd\";}";
        /*Map<String, String> param = new HashMap<String, String>();
        param.put("a","5.00");
        param.put("b","13");
        param.put("c","27");*/

        map.put("params",param);
        map.put("code",code);
    }

    public Map<String, String> paramMap(){
        Map<String, String> map = new HashMap<String, String>();

        String param = "{\"a\":\"6.00\",\"b\":\"13\",\"c\":\"27\"}";
        /*String code = "import com.alibaba.fastjson.JSON;def toDo(vv){def dd = null;vv = vv.split(\";\");String a=vv[0];" +
                "Map<String,String>map=JSON.parseObject(a);" +
                "BigDecimal num1=new BigDecimal(map.get(\"a\"));" +
                "BigDecimal num2=new BigDecimal(map.get(\"b\"));" +
                "try{result=num1.multiply(num2);dd=result;}catch(Exception e){dd=0;}\n" +
                "return \"$dd\";}";*/

        String forEach = "for(int i=0;i<array.length;i++){if(array[i].compareTo(max) > 1 ){max=array[i];}}";

        String code = "import com.alibaba.fastjson.JSON;def toDo(vv){def dd = null;vv = vv.split(\";\");String a=vv[0];" +
                "Map<String,String>map=JSON.parseObject(a);" +
                "BigDecimal num1 = new BigDecimal(map.get(\"a\"));" +
                "BigDecimal num2 = new BigDecimal(map.get(\"b\"));" +
                "BigDecimal num3 = new BigDecimal(map.get(\"c\"));" +
                "BigDecimal[] array = new BigDecimal[3];" +
                "array[0] = num1;" +
                "array[1] = num2;" +
                "array[2] = num3;" +
                "BigDecimal max = array[0],min = array[0];" +
                "try{for(int i=0;i<array.length;i++){if(array[i].compareTo(max) == 1 ){max=array[i];}};" +
                "result = num1.multiply(num2);dd = min;}catch(Exception e){dd = 0;}\n" +
                "return \"$dd\";}";
        map.put("params",param);
        map.put("code",code);
        return map;
    }

    @Test
    public void industryMapCalculateTest() {
        // 入参构建
        Map<String, String> map = paramMap();

        // code 代码处理（去转义）
        String code = map.get ("code").replace ("\\","");
        // 空指针异常处理：获取 params
        String params = StringUtils.isEmpty (map.get ("params")) ? "" : map.get ("params");
        String vResult = "";
        log.info("code:" + code);
        log.info("params:" + params);

        try {
            vResult = GroovyUtils.runGroovyScript (code,"toDo",new String[] {params});
        } catch (Exception e) {
            e.printStackTrace ();
            log.info("异常信息：" + e.getMessage ());
            System.out.println("测试失败"+ e.getMessage ());
        }
        System.out.println("=========================================================================================");
        log.info("vResult:" + vResult);
        System.out.println("测试成功:" + vResult);
    }


}
