package com.cc.springbase.scan.processors;

import com.cc.springbase.enhance.EnhanceProxyFactory;
import com.cc.springbase.enhance.ProxyEnhancer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @Description spring 扫描bean初始化拦截处理
 * @Author sen.hu
 * @Date 2018/11/27 14:14
 **/
@Component
public class SpringBeanProcessor implements BeanPostProcessor {

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ProxyEnhancer proxyEnhancer = bean.getClass().getDeclaredAnnotation(ProxyEnhancer.class);
        if (proxyEnhancer != null && proxyEnhancer.enabled()) {
            return enhance(bean.getClass());
        }
        return bean;
    }

    private Object enhance(Class clazz) {
        if (clazz.isInterface()) {
            ClassLoader classLoader = clazz.getClassLoader();
            Class[] interfaces = new Class[] {clazz};
            EnhanceProxyFactory.BeanEnhanceProxy beanEnhanceProxy = new EnhanceProxyFactory.BeanEnhanceProxy();
            return Proxy.newProxyInstance(classLoader, interfaces, beanEnhanceProxy);
        } else {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(clazz);
            enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
            enhancer.setCallback(new EnhanceProxyFactory.MethodEnhancer());
            return enhancer.create();
        }
    }
}
