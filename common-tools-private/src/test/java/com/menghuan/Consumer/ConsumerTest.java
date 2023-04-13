package com.menghuan.Consumer;

import cn.hutool.core.io.LineHandler;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer接口是一个消费型的接口，只要实现它的accept方法，就能作为消费者来输出信息。
 * lambda、方法引用都可以是一个Consumer类型，因此他们可以作为forEach的参数，用来协助Stream输出信息。
 * Consumer还有很多变种，例如IntConsumer、DoubleConsumer与LongConsumer等，归根结底，这些变种其实只是指定了Consumer中的泛型而已，方法上并无变化。
 */
public class ConsumerTest {

    @Test
    public void overrideAccept(){
        Consumer<Object> consumer = new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                System.out.println(o+"-1");
            }
        };

        consumer.accept("K");
    }

    @Test
    public void overrideAcceptRemark(){
        Consumer<Object> consumer = new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                System.out.println(o+"-1");
            }
        };

        // 用lambda表达式来对此匿名内部类进行改写
        // consumer = i-> System.out.println(i);
        consumer = System.out::println;

        consumer.accept("K2");
    }


    @Test
    public void dealList(){
        /*ArrayList<Integer> list = new ArrayList<>(8);
        list.add(1);
        list.add(2);
        list.add(3);*/
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        /*for (int i = 0; i < integers.size(); i++) {
            consumer.accept(i);
        }*/
        /*for (Integer integer : integers) {
            consumer.accept(integer);
        }*/
        // integers.forEach(a->consumer.accept(a));

        // integers.stream().forEach(a->consumer.accept(a));
    }

    @Test
    public void dealListSecond(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // Consumer<Integer> consumer = a -> System.out.println(a);

        // TODO
        // LineHandler lineHandler = System.out::println;

        Consumer<Integer> consumer = System.out::println;

        /*for (int i = 0; i < integers.size(); i++) {
            consumer.accept(i);
        }*/
        /*for (Integer integer : integers) {
            consumer.accept(integer);
        }*/

        // integers.forEach(a->consumer.accept(a));
        // integers.forEach(consumer::accept);
        // integers.forEach(consumer);

        integers.forEach(System.out::println);

        // integers.stream().forEach(a->consumer.accept(a));
    }

}
