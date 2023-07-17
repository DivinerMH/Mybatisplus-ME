package java.com.menghuan.menghuan.stringJSON;

import org.junit.Test;

/**
 * @Author: menghuan
 * @Date: 2021/11/24 15:50
 */
public class StringFormat {

    @Test
    public void stringFormatTest(){
        String key = "";
        String kongKey = String.format("key_%s", "Kong");
        String kongFuKey = String.format("key_%s_%s", "Kong","Fu");
        String kongFuHuaXiaKey = String.format("key_%s_%s_%s", "Kong","Fu","HuaXia");
        System.out.println(kongKey);
        System.out.println(kongFuKey);
        System.out.println(kongFuHuaXiaKey);
    }
}
