package com.cc.design.pattern.proxy;

/**
 * 静态代理：组件1的代理
 */
public class ProxyComponent1 implements Component {
    /**
     * 代理的组件
     */
    private Component component;

    public ProxyComponent1() {
        this.component = new Component1();
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}
