package com.cc.springbase;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2018/11/26 16:45
 **/
public final class EnhanceProxy {
    //https://www.jianshu.com/p/7c2948f64b1c
    private static class MethodEnhanceProxy implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            return null;
        }
    }

    private static class BeanEnhanceProxy implements InvocationHandler {

        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            return null;
        }
    }

    public static BeanEnhanceProxy newBeanEnhanceProxy() {
        //TODO
        return null;
    }

}
