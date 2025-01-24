package com.menghuan.UUID;

import java.io.Serializable;
import java.util.UUID;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: menghuan
 * @Date: 2022/9/13 10:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TestUUIDTest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    private String name;


    public static void main(String[] args) {
        TestUUIDTest testUuidTest = new TestUUIDTest();
        testUuidTest.setName("测试");
        // uuidTest.setId(null);
        testUuidTest.setId(UUID.randomUUID().toString());
        System.out.println("Result ID 信息：" + testUuidTest.getId());
    }


}


