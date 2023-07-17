package java.com.menghuan.menghuan.stringJSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author: menghuan
 * @Date: 2022/9/28 17:34
 */
public class StringToList {

    @Test
    public void sss(){
        String str = "[{\"createTime\":\"2020-03-10 02:04:28\",\"tenantId\":1,\"name\":\"机场\",\"updateTime\":\"2022-08-09 17:10:05\",\"id\":1,\"delFlag\":\"0\",\"status\":\"0\"},{\"createTime\":\"2020-03-18 12:22:28\",\"tenantId\":1,\"name\":\"航站楼\",\"updateTime\":\"2022-08-09 17:10:06\",\"id\":2,\"delFlag\":\"0\",\"status\":\"0\"},{\"createTime\":\"2020-03-18 12:22:36\",\"tenantId\":1,\"name\":\"功能区\",\"updateTime\":\"2022-08-09 17:10:08\",\"id\":3,\"delFlag\":\"0\",\"status\":\"0\"},{\"createTime\":\"2020-03-18 12:22:42\",\"tenantId\":1,\"name\":\"园区\",\"updateTime\":\"2022-08-09 17:10:10\",\"id\":4,\"delFlag\":\"0\",\"status\":\"0\"},{\"createTime\":\"2022-08-12 17:35:46\",\"tenantId\":1,\"name\":\"空间类型\",\"updateTime\":\"2022-08-15 11:36:02\",\"id\":8,\"delFlag\":\"0\",\"status\":\"0\"},{\"createTime\":\"2022-08-15 10:59:28\",\"tenantId\":1,\"name\":\"空间类型\",\"updateTime\":\"2022-08-15 10:59:40\",\"id\":9,\"delFlag\":\"0\",\"status\":\"0\"},{\"createTime\":\"2022-08-15 10:59:48\",\"tenantId\":1,\"name\":\"空间类型\",\"updateTime\":\"2022-08-15 10:59:48\",\"id\":10,\"delFlag\":\"0\",\"status\":\"0\"},{\"createTime\":\"2022-08-15 11:39:47\",\"tenantId\":1,\"name\":\"楼栋\",\"updateTime\":\"2022-08-15 11:39:47\",\"id\":13,\"delFlag\":\"0\",\"status\":\"0\"},{\"createTime\":\"2022-08-15 11:40:08\",\"tenantId\":1,\"name\":\"楼层\",\"updateTime\":\"2022-08-15 11:40:08\",\"id\":14,\"delFlag\":\"0\",\"status\":\"0\"},{\"createTime\":\"2022-08-16 17:15:24\",\"tenantId\":1,\"name\":\"888\",\"updateTime\":\"2022-08-16 17:15:24\",\"id\":34,\"delFlag\":\"0\",\"status\":\"0\"},{\"createTime\":\"2022-08-18 15:06:35\",\"tenantId\":1,\"name\":\"楼层1\",\"updateTime\":\"2022-08-18 15:06:35\",\"id\":39,\"delFlag\":\"0\",\"status\":\"0\"},{\"createTime\":\"2022-08-18 15:54:32\",\"tenantId\":1,\"name\":\"园区测试11\",\"updateTime\":\"2022-08-18 15:54:32\",\"id\":41,\"delFlag\":\"0\",\"status\":\"0\"},{\"createTime\":\"2022-08-18 16:33:21\",\"tenantId\":1,\"name\":\"园区测试466\",\"updateTime\":\"2022-08-18 16:37:34\",\"id\":45,\"delFlag\":\"0\",\"status\":\"0\"}]";
        JSONArray jsonArray = JSON.parseArray(str);
        // System.out.println(jsonArray.toString());
        List<List> lists = jsonArray.toJavaList(List.class);
        System.out.println(lists);
    }
}
