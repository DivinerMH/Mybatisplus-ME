package com.hanchan.aop;

import com.hanchan.proxyPattern.StaticProxyPerson;

/**
 * 参考：https://mp.weixin.qq.com/s/Wio2tN8xGwbr6xAcBnoE5g
 * @Author: menghuan
 * @Date: 2021/6/24 14:20
 */
public class AgentProxyTest {

    public static void main(String[] args) {
        AgentProxy agentProxy = new AgentProxy();
        agentProxy.doSkill();
    }

}
