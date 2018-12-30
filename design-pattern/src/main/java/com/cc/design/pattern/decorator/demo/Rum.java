package com.cc.design.pattern.decorator.demo;

/**
 * 朗姆酒
 */
public class Rum implements Drink {

    @Override
    public String description() {
        return "这是朗姆酒";
    }

    @Override
    public int price() {
        return 80;
    }

    @Override
    public void make() {
        System.out.println("制作朗姆酒");
    }
}
