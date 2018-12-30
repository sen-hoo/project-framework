package com.cc.design.pattern.proxy;

import com.cc.design.pattern.proxy.dynamic.CglibProxyHanlder;
import com.cc.design.pattern.proxy.dynamic.DynamicProxyHandler;

public class Test {
    public static void main(String[] args) {
        //测试静态代理
        ProxyComponent1 proxyComponent1 = new ProxyComponent1();
        proxyComponent1.doSomething();
       //测试java反射动态代理
        testDynProxy();
        //测试cglib实现动态代理
        testCglibDynProxy();
    }

    private static void testDynProxy() {
        Component component = (Component) new DynamicProxyHandler().bindTarget(new Component1());
        component.doSomething();
    }
    public static void testCglibDynProxy() {
        Component component = (Component) CglibProxyHanlder.bindTarget(new Component1());
        component.doSomething();
    }


}
