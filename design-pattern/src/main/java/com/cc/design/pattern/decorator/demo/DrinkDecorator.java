package com.cc.design.pattern.decorator.demo;

/**
 *  饮料装饰器
 */
public class DrinkDecorator implements Drink {
    /**
     * 真正酒的引用
     */
    private Drink drink;

    public DrinkDecorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String description() {
        return drink.description();
    }

    @Override
    public int price() {
        //有具体子类价格决定
        return drink.price();
    }

    @Override
    public void make() {
        //具体饮料子类制作
        drink.make();
    }
}
