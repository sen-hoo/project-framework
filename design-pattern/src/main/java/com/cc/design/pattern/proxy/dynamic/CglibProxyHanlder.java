package com.cc.design.pattern.proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 利用cglib实现动态代理
 */
public class CglibProxyHanlder implements MethodInterceptor {

    private static class InstanceHolder {
        private static CglibProxyHanlder cglibProxyHanlder = new CglibProxyHanlder();
    }

    private CglibProxyHanlder(){

    }

    public static CglibProxyHanlder getInstance() {
        return InstanceHolder.cglibProxyHanlder;
    }

    public static Object bindTarget(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(getInstance());
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before cglib proxy method execute");
        System.out.println(String.format("cglib proxy method %s start to run", method.getName()));
        Object ret = proxy.invokeSuper(obj, args);
        System.out.println(String.format("cglib proxy method %s run over", method.getName()));
        System.out.println("after cglib proxy method execute");
        return ret;
    }
}
