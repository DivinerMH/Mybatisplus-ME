package com.menghuan.proxyPattern;

/**
 * 简易版静态代理
 *      静态代理，目标对象和代理对象都需要实现自己的父类方法
 *          目标对象：SunWuKOng
 *          代理对象：Agent
 * @Limit 一旦父类增加或修改了，需要在所有子类中一起变动，维护十分困难。所以一般在项目中很少使用静态代理。
 * @Author: menghuan
 * @Date: 2021/6/24 10:24
 */
public interface StaticProxyPerson {

    /**
     * 任务技能
     */
    public void skill();

    public void role();

}
