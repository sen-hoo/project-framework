package com.cc.project.test;

/**
 * @Description 测试启动方法
 * @Author sen.hu
 * @Date 2019/1/3 17:20
 **/
public class TestBoot {
    public static void main(String[] args) {
        System.getenv().forEach((k, v) -> {
            System.out.println(k + "\t" + v);
        });
        System.out.println(System.getProperty("file.encoding"));
        System.out.println("我是一个好人");
    }
}
