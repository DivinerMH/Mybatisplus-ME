package com.menghuan.designPattern.builderPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 生成器模式 - 经典用例 - 测试
 * 
 * @author menghuan
 */
public class UserTest {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        User user1 = User.builder().id(1).name("ONE").sex("1").build();
        User user2 = User.builder().id(2).name("ZERO").sex("0").build();
        User user3 = User.builder().id(3).name("TWO").sex("0").build();
        User user4 = User.builder().id(4).name("FOUR").sex("1").build();
        User user5 = User.builder().id(5).name("ONE").sex("1").build();

        // 使用lombok没有无参构造方法，只有具有全部参数的构造方法
        User user = new User(1, "1", "1");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        System.out.println("筛选前：" + userList);
        userList = userList.stream().filter(o -> o.getName().equals("ONE")).collect(Collectors.toList());
        System.out.println("筛选后：" + userList);
    }

}