package com.cc.springbase;

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
        if (innerClass.isInterface()) {
            return (T) EnhanceProxy.enhanceBean(innerClass);
        } else {//java class
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(innerClass);
            enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
            enhancer.setCallback(EnhanceProxy.newMethodEnhancerProxy());
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
