package com.cc.design.pattern.decorator;

/**
 * 具体装饰实现
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        System.out.println("this is in decorator, before component execute");
        super.doSomething();
        System.out.println("this is in decorator, after component execute");
    }
}
