package com.cc.springframework.base.enhance;

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
public final class EnhanceProxyFactory {

    private static final Logger logger = LoggerFactory.getLogger(EnhanceProxyFactory.class);
    //https://www.jianshu.com/p/7c2948f64b1c
    public static class MethodEnhancer implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            logger.debug("start execute: " + o.getClass().getName() + "\t" + method.getName() + "\t" + JSON.toJSONString(objects));
            long startTime = System.currentTimeMillis();
            Object ret = methodProxy.invokeSuper(o, objects);
            LogInfo logInfo = new LogInfo(o.getClass().getName().substring(0, o.getClass().getName().indexOf("$$")), method.getName(), objects, System.currentTimeMillis() - startTime, ret);
            logger.info("finish execute: " + logInfo.toString());
            return ret;
        }
    }

    public static class BeanEnhanceProxy implements InvocationHandler {

        @Override
        public Object invoke(Object proxyObj, Method method, Object[] args) throws Throwable {
            logger.debug(proxyObj.getClass().getName() + "\t" + method.getName() + "\t" + JSON.toJSONString(args));
            long startTime = System.currentTimeMillis();
            Object ret = method.invoke(proxyObj, args);
            LogInfo logInfo = new LogInfo(proxyObj.getClass().getName(), method.getName(), args, System.currentTimeMillis() - startTime, ret);
            logger.info("finish executed: " + logInfo.toString());
            return ret;
        }
    }

    public static <T> T enhanceBean(Class<T> clazz) {
        ClassLoader classLoader = clazz.getClassLoader();
        Class[] interfaces = new Class[] {clazz};
        BeanEnhanceProxy beanEnhanceProxy = new BeanEnhanceProxy();
        return (T) Proxy.newProxyInstance(classLoader, interfaces, beanEnhanceProxy);
    }

}
