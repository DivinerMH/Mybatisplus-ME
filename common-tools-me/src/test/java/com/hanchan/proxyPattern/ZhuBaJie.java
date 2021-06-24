package com.hanchan.proxyPattern;

/**
 * 原生对象
 * @Author: menghuan
 * @Date: 2021/6/24 10:26
 */
public class ZhuBaJie implements StaticProxyPerson {

    @Override
    public void skill() {
        System.out.println("我是天蓬元帅猪八戒，一耙定若水");
    }

    @Override
    public void role() {
        System.out.println("猪科");
    }

}