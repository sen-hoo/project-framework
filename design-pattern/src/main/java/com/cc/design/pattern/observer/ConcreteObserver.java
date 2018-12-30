package com.cc.design.pattern.observer;

public class ConcreteObserver implements Observer {

    @Override
    public void onSubjectCall() {
        System.out.println("be called and do something");
    }
}
