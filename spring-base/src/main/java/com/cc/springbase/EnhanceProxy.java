package com.cc.springbase;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @Description 代理日志增强
 * @Author sen.hu
 * @Date 2018/11/26 16:45
 **/
public final class EnhanceProxy {

    private static final Logger logger = LoggerFactory.getLogger(EnhanceProxy.class);
    //https://www.jianshu.com/p/7c2948f64b1c
    private static class MethodEnhanceProxy implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            logger.debug(o.getClass().getName() + "\t" + method.getName() + "\t" + JSON.toJSONString(objects));
            long startTime = System.currentTimeMillis();
            Object ret = methodProxy.invoke(o, objects);
            logger.info(o.getClass().getName() + "\t" + method.getName() + "\t" + JSON.toJSONString(objects) + "\t" + JSON.toJSONString(ret) + "\t" + String.valueOf(System.currentTimeMillis() - startTime));
            return ret;
        }
    }

    private static class BeanEnhanceProxy implements InvocationHandler {

        @Override
        public Object invoke(Object proxyObj, Method method, Object[] args) throws Throwable {
            logger.debug(proxyObj.getClass().getName() + "\t" + method.getName() + "\t" + JSON.toJSONString(args));
            long startTime = System.currentTimeMillis();
            Object ret = method.invoke(proxyObj, args);
            logger.info(proxyObj.getClass().getName() + "\t" + method.getName() + "\t" + JSON.toJSONString(args) + "\t" + JSON.toJSONString(ret) + "\t" + String.valueOf(System.currentTimeMillis() - startTime));
            return ret;
        }
    }

    public static <T> T enhanceBean(Class<T> clazz) {
        ClassLoader classLoader = clazz.getClassLoader();
        Class[] interfaces = new Class[] {clazz};
        BeanEnhanceProxy beanEnhanceProxy = new BeanEnhanceProxy();
        return (T) Proxy.newProxyInstance(classLoader, interfaces, beanEnhanceProxy);
    }

    public static MethodEnhanceProxy newMethodEnhancerProxy() {
        return new MethodEnhanceProxy();
    }

}
