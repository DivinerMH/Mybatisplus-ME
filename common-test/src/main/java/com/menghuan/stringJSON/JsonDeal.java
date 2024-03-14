package com.menghuan.stringJSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author:menghuan
 * @Date:2020/12/16 15:49
 */
public class JsonDeal {

    static {
        Map<String, Object> temporaryMap = new HashMap<>();
        temporaryMap.put("configId", 1);
        temporaryMap.put("ruleType", 2);
        temporaryMap.put("ruleId", 3);
    }

    @Test
    public void xxxTest() {
        // String json = new String();
        String json = "{\u2028    \"configId\": 399,\n" +
                "    \"ruleType\": \"0\",\n" +
                "    \"ruleId\": 399,\n" +
                "}，\n" +
                "{\u2028    \"configId\": 399,\n" +
                "    \"ruleType\": \"0\",\n" +
                "    \"ruleId\": 399,\n" +
                "}";
        JSONArray objects = JSON.parseArray(json);
        System.out.println(objects);
    }

    @Test
    public void xxxTest2() {
        // String json = new String();
        String json = "[{\n" +
                "\t\t\"configId\": 322,\n" +
                "\t\t\"ruleType\": \"1\",\n" +
                "\t\t\"ruleId\": 1000\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"configId\": 42,\n" +
                "\t\t\"ruleType\": \"1\",\n" +
                "\t\t\"ruleId\": 2222\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"configId\": 399,\n" +
                "\t\t\"ruleType\": \"0\",\n" +
                "\t\t\"ruleId\": 399\n" +
                "\t}\n" +
                "]";
        JSONArray objects = JSON.parseArray(json);
        System.out.println(objects);
        for (Object object : objects) {
            System.out.println("object" + object);
        }
    }

    @Test
    public void xxxTest3() {
        // String json = new String();
        String json = "[{\n" +
                "\t\t\"configId\": 322,\n" +
                "\t\t\"ruleType\": \"1\",\n" +
                "\t\t\"ruleId\": 1000\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"configId\": 42,\n" +
                "\t\t\"ruleType\": \"1\",\n" +
                "\t\t\"ruleId\": 2222\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"configId\": 399,\n" +
                "\t\t\"ruleType\": \"0\",\n" +
                "\t\t\"ruleId\": 399\n" +
                "\t}\n" +
                "]";
        JSONArray objects = JSON.parseArray(json);
        /*        List<TemporaryEntity> temporaryEntities = objects.toJavaList(TemporaryEntity.class);
        // System.out.println("temporaryEntities:" + temporaryEntities);
        for (TemporaryEntity temporaryEntity : temporaryEntities) {
            System.out.println("temporaryEntity:" + temporaryEntity);
        }*/
    }

    @Test
    public void xxxTest4() {
        String jsonStr = "{\n" +
                "\t\"total\": 3,\n" +
                "\t\"rows\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"sendId\": 1638947137,\n" +
                "\t\t\t\"isShowStr\": \"\",\n" +
                "\t\t\t\"statusStr\": \"否\",\n" +
                "\t\t\t\"remark\": \"\",\n" +
                "\t\t\t\"delFlag\": \"1\",\n" +
                "\t\t\t\"gmtUpdateTime\": \"2022-03-07 16:05:31\",\n" +
                "\t\t\t\"proIdStr\": \"讯饶DDC\",\n" +
                "\t\t\t\"commandName\": \"读电能\",\n" +
                "\t\t\t\"protocolName\": \"读取电能数据\",\n" +
                "\t\t\t\"proName\": \"讯饶DDC\",\n" +
                "\t\t\t\"actionTypeStr\": \"功能键\",\n" +
                "\t\t\t\"protocolIdStr\": \"读取电能数据\",\n" +
                "\t\t\t\"isShow\": \"\",\n" +
                "\t\t\t\"delFlagStr\": \"启用\",\n" +
                "\t\t\t\"actionType\": \"7\",\n" +
                "\t\t\t\"protocolId\": 1646623910,\n" +
                "\t\t\t\"isWriteStr\": \"否\",\n" +
                "\t\t\t\"proId\": 1646206284,\n" +
                "\t\t\t\"tenantId\": 0,\n" +
                "\t\t\t\"gmtCreateTime\": \"2022-03-07 16:04:04\",\n" +
                "\t\t\t\"isWrite\": \"0\",\n" +
                "\t\t\t\"status\": \"0\",\n" +
                "\t\t\t\"actionName\": \"读电能\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"sendId\": 1638947136,\n" +
                "\t\t\t\"isShowStr\": \"\",\n" +
                "\t\t\t\"statusStr\": \"否\",\n" +
                "\t\t\t\"remark\": \"\",\n" +
                "\t\t\t\"delFlag\": \"1\",\n" +
                "\t\t\t\"gmtUpdateTime\": \"2022-03-07 16:03:44\",\n" +
                "\t\t\t\"proIdStr\": \"讯饶DDC\",\n" +
                "\t\t\t\"commandName\": \"关\",\n" +
                "\t\t\t\"protocolName\": \"IO424CAT1.DO1写入\",\n" +
                "\t\t\t\"proName\": \"讯饶DDC\",\n" +
                "\t\t\t\"actionTypeStr\": \"关\",\n" +
                "\t\t\t\"protocolIdStr\": \"IO424CAT1.DO1写入\",\n" +
                "\t\t\t\"isShow\": \"\",\n" +
                "\t\t\t\"delFlagStr\": \"启用\",\n" +
                "\t\t\t\"actionType\": \"2\",\n" +
                "\t\t\t\"protocolId\": 1646624051,\n" +
                "\t\t\t\"isWriteStr\": \"否\",\n" +
                "\t\t\t\"proId\": 1646206284,\n" +
                "\t\t\t\"tenantId\": 0,\n" +
                "\t\t\t\"gmtCreateTime\": \"2022-03-07 16:03:44\",\n" +
                "\t\t\t\"isWrite\": \"0\",\n" +
                "\t\t\t\"status\": \"0\",\n" +
                "\t\t\t\"actionName\": \"\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"sendId\": 1638947135,\n" +
                "\t\t\t\"isShowStr\": \"\",\n" +
                "\t\t\t\"statusStr\": \"否\",\n" +
                "\t\t\t\"remark\": \"\",\n" +
                "\t\t\t\"delFlag\": \"1\",\n" +
                "\t\t\t\"gmtUpdateTime\": \"2022-03-07 16:03:32\",\n" +
                "\t\t\t\"proIdStr\": \"讯饶DDC\",\n" +
                "\t\t\t\"commandName\": \"开\",\n" +
                "\t\t\t\"protocolName\": \"IO424CAT1.DO1写入\",\n" +
                "\t\t\t\"proName\": \"讯饶DDC\",\n" +
                "\t\t\t\"actionTypeStr\": \"开\",\n" +
                "\t\t\t\"protocolIdStr\": \"IO424CAT1.DO1写入\",\n" +
                "\t\t\t\"isShow\": \"\",\n" +
                "\t\t\t\"delFlagStr\": \"启用\",\n" +
                "\t\t\t\"actionType\": \"1\",\n" +
                "\t\t\t\"protocolId\": 1646624051,\n" +
                "\t\t\t\"isWriteStr\": \"否\",\n" +
                "\t\t\t\"proId\": 1646206284,\n" +
                "\t\t\t\"tenantId\": 0,\n" +
                "\t\t\t\"gmtCreateTime\": \"2022-03-07 16:03:32\",\n" +
                "\t\t\t\"isWrite\": \"0\",\n" +
                "\t\t\t\"status\": \"0\",\n" +
                "\t\t\t\"actionName\": \"\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        System.out.println(jsonObject.toJSONString());

        Object rows = jsonObject.get("rows");
        System.out.println("=========================================================================================");
        System.out.println(rows.toString());
        System.out.println("=========================================================================================");
        List<Object> list = JSONArray.parseArray(rows.toString(), Object.class);
        System.out.println(list);
        for (Object o : list) {

        }

    }


    @Test
    public void xxxTest5() {
        String jsonStr = "select v.month,IFNULL(b.count,0) as count from (\n" +
                "    SELECT DATE_FORMAT(CURDATE(), '%Y-%m') AS `month` \n" +
                "    UNION SELECT DATE_FORMAT((CURDATE() - INTERVAL 1 MONTH), '%Y-%m') AS `month` \n" +
                "    UNION SELECT DATE_FORMAT((CURDATE() - INTERVAL 2 MONTH), '%Y-%m') AS `month` \n" +
                "    UNION SELECT DATE_FORMAT((CURDATE() - INTERVAL 3 MONTH), '%Y-%m') AS `month` \n" +
                "    UNION SELECT DATE_FORMAT((CURDATE() - INTERVAL 4 MONTH), '%Y-%m') AS `month` \n" +
                "    UNION SELECT DATE_FORMAT((CURDATE() - INTERVAL 5 MONTH), '%Y-%m') AS `month` \n" +
                "    UNION SELECT DATE_FORMAT((CURDATE() - INTERVAL 6 MONTH), '%Y-%m') AS `month` \n" +
                "    UNION SELECT DATE_FORMAT((CURDATE() - INTERVAL 7 MONTH), '%Y-%m') AS `month` \n" +
                "    UNION SELECT DATE_FORMAT((CURDATE() - INTERVAL 8 MONTH), '%Y-%m') AS `month` \n" +
                "    UNION SELECT DATE_FORMAT((CURDATE() - INTERVAL 9 MONTH), '%Y-%m') AS `month` \n" +
                "    UNION SELECT DATE_FORMAT((CURDATE() - INTERVAL 10 MONTH), '%Y-%m') AS `month` \n" +
                "    UNION SELECT DATE_FORMAT((CURDATE() - INTERVAL 11 MONTH), '%Y-%m') AS `month`\n" +
                ") v \n" +
                "left join\n" +
                "(select \n" +
                "\tleft(create_time,7) as 'month',count(*) as count\n" +
                "\tfrom sp_bs_company_count as a\t\n" +
                "\t\twhere DATE_FORMAT(a.create_time,'%Y-%m')> DATE_FORMAT(date_sub(curdate(), interval 12 month),'%Y-%m')\n" +
                "\t\tGROUP BY month\n" +
                ")b\n" +
                "on v.month = b.month \n" +
                "group by v.month, count\n" +
                "order by v.month desc";
    }

    @Test
    public void xxxTest6() {
        String jsonStr = "\"id\" INT IDENTITY(1, 1) NOT NULL";
    }

}



