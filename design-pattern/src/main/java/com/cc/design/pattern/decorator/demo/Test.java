package com.cc.design.pattern.decorator.demo;

public class Test {

    public static void main(String[] args) {
        Drink brandyCocktail = new Cocktail(new Brandy());
        Drink rumCocktail = new Cocktail(new Rum());
        brandyCocktail.make();
        System.out.println(brandyCocktail.description() + "\tprice:" + brandyCocktail.price());
        System.out.println("=======================");
        rumCocktail.make();
        System.out.println(rumCocktail.description() + "\tprice:" + rumCocktail.price());
    }

}
