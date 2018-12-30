package com.cc.design.pattern.decorator.demo;

/**
 * 鸡尾酒
 */
public class Cocktail extends DrinkDecorator {

    private int cokePrice = 2;
    private int sprite = 1;

    public Cocktail(Drink drink) {
        super(drink);
    }

    @Override
    public String description() {
        return "我是鸡尾酒";
    }

    @Override
    public int price() {
        return super.price() + cokePrice + sprite;
    }

    @Override
    public void make() {
        System.out.println("开始制作鸡尾酒");
        System.out.println("加入可乐");
        super.make();
        System.out.println("加入雪碧");
        System.out.println("制作结束");
    }
}
