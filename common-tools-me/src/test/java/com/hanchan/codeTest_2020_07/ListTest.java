package com.hanchan.codeTest_2020_07;

import org.junit.Test;

import java.util.*;

/**
 * @Author:menghuan
 * @Date:2020/8/17 14:40
 */
public class ListTest {

    //3、set集合去重，不打乱顺序
    @Test
    public void test1(){
        List<String> list  =   new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        list.add("aba");
        list.add("aaa");
        list.add("aca");
        list.add("acc");
        list.add("add");

        Set set = new HashSet(list);
        list.clear();
        list.addAll(set);
        System.out.println( "去重后的集合： " + list);
    }

    @Test
    public void test2(){
        List<String> list  =   new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        list.add("aba");
        list.add("aaa");
        list.add("aca");
        list.add("acc");
        list.add("add");

        Set treeSet = new TreeSet(list);
        list.clear();
        list.addAll(treeSet);
        System.out.println( "去重后的集合： " + list);
    }

}
