package com.menghuan.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.compress.utils.Lists;
import org.junit.Test;

public class streamTest {

    @Test
    public void streamReturn() {
        ArrayList<Student> list = Lists.newArrayList();
        for (int i = 5; i > 0; i--) {
            Student build = Student.builder().id(1).name("周" + i).sex(i % 2 == 0 ? "男" : "女").build();
            list.add(build);
        }
        System.out.println(list);
        List<Student> collect = list.stream().map(e -> Student.builder().id(e.getId()).name(e.getName()).build())
            .collect(Collectors.toList());
        System.out.println(collect);
    }

}
