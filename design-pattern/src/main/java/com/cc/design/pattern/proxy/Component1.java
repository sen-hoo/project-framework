package com.cc.design.pattern.proxy;

public class Component1 implements Component {

    @Override
    public void doSomething() {
        System.out.println("我才是真正的组件");
    }
}
