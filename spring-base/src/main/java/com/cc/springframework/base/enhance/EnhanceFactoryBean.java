package com.cc.springframework.base.enhance;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.lang.Nullable;

public class EnhanceFactoryBean<T> implements InitializingBean, FactoryBean<T> {

    private String innerClassName;

    public String getInnerClassName() {
        return innerClassName;
    }

    public void setInnerClassName(String innerClassName) {
        this.innerClassName = innerClassName;
    }

    @Nullable
    @Override
    public T getObject() throws Exception {
        Class innerClass = Class.forName(innerClassName);
        if (innerClass.isInterface() && !innerClass.isAnnotation()) {
            return (T) EnhanceProxyFactory.enhanceBean(innerClass);
        } else {//java class
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(innerClass);
            enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
            enhancer.setCallback(new EnhanceProxyFactory.MethodEnhancer());
            return (T) enhancer.create();
        }
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        try {
            return Class.forName(innerClassName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
