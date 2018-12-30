package com.cc.design.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 利用java反射实现动态代理
 * 所有被代理的对象必须实现摸一个接口
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object target;

    /**
     * 绑定目标对象
     * @param target
     * @return
     */
    public Object bindTarget(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before target execute");
        System.out.println(String.format("target method %s star to run", method.getName()));
        Object ret = method.invoke(target, args);
        System.out.println(String.format("target method %s run over", method.getName()));
        System.out.println("after target execute");
        return ret;
    }
}
