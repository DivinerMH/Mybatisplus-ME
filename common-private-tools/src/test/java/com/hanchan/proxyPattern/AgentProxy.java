package com.hanchan.proxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理人
 *      所谓动态代理就是借用反射来创建代理对象，借用反射来创建代理对象的好处就是通用性极高。
 *      这样就避免了上层接口改变，代理对象也要修改代码这一蛋疼行为。
 * @Author: menghuan
 * @Date: 2021/6/24 11:30
 */
public class AgentProxy {

    private Object object;

    public AgentProxy(Object object){
        this.object = object;
    }

    public Object getProxyInstance(){
        Object o = Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        System.out.println("我是代理人");
                        // 指定具体目标对象方法
                        Object invoke = method.invoke(object, objects);
                        return invoke;
                    }
                });
        return o;
    }

}
