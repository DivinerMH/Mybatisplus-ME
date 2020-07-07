package com.menghuan.tools;

import org.junit.Test;
import java.util.UUID;

/**
 * @Author:menghuan
 * @Date:2020/6/22 14:09
 */
public class UUID_test {

    @Test
    public void uuid_test(){
        java.util.UUID uuid = java.util.UUID.randomUUID();
        System.out.println("UUID:" + uuid);
    }


}
