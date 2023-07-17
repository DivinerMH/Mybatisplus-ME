package java.com.menghuan.menghuan.proxyPattern;

/**
 * 静态代理人
 * @Author: menghuan
 * @Date: 2021/6/24 10:30
 */
public class Agent implements StaticProxyPerson {

    private StaticProxyPerson staticProxyPerson;

    public Agent(StaticProxyPerson staticProxyPerson){
        this.staticProxyPerson = staticProxyPerson;
    }

    @Override
    public void skill() {
        System.out.println("我是代理人");
        staticProxyPerson.skill();
        System.out.println("========================END=====================");
    }

    @Override
    public void role() {

    }


}
