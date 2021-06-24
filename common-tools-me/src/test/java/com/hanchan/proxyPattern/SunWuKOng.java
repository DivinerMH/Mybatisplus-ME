package com.hanchan.proxyPattern;

/**
 * 原生对象
 * @Author: menghuan
 * @Date: 2021/6/24 10:26
 */
public class SunWuKOng implements StaticProxyPerson {

    @Override
    public void skill() {
        System.out.println("我是齐天大圣孙悟空，一棒定乾坤");
    }

    @Override
    public void role() {
        System.out.println("猴科");
    }

}
