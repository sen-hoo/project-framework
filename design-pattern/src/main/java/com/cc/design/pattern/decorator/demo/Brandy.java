package com.cc.design.pattern.decorator.demo;

/**
 * 白兰地
 */
public class Brandy implements Drink {
    @Override
    public String description() {
        return "这是白兰地酒";
    }

    @Override
    public int price() {
        return 100;
    }

    @Override
    public void make() {
        System.out.println("制作白兰地");
    }
}
