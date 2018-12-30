package com.cc.design.pattern.decorator.demo;

public interface Drink {
    /**
     * 饮料描述
     * @return 描述
     */
    String description();

    /**
     * 价格
     * @return
     */
    int price();

    /**
     * 制作饮料
     */
    void make();
}
