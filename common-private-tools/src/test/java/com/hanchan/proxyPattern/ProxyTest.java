package com.hanchan.proxyPattern;

import org.junit.Test;

/**
 * @Author: menghuan
 * @Date: 2021/6/24 10:34
 */
public class ProxyTest {

    /**
     * 静态代理测试
     */
    @Test
    public void StaticProxyTest() {
        // 静态代理对象
        Agent agent = new Agent(new SunWuKOng());
        agent.skill();

        Agent agent2 = new Agent(new ZhuBaJie());
        agent2.skill();
    }

    /**
     * 动态代理测试
     */
    @Test
    public void DynamicProxyTest() {
        // 原始对象
        // 注意：此处用原始对象的接口保存原始对象
        // StaticProxyPerson sunWuKOng = new SunWuKOng();
        StaticProxyPerson sunWuKOng = new ZhuBaJie();
        // Object proxyInstance = new AgentProxy(sunWuKOng).getProxyInstance();
        StaticProxyPerson proxyInstance = (StaticProxyPerson) new AgentProxy(sunWuKOng).getProxyInstance();
        proxyInstance.skill();
    }

}
