package com.cc.springframework.base;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @Description spring基础扫描器
 * @Author sen.hu
 * @Date 2018/11/26 16:00
 **/
public class SpringBaseBeanScanner extends ClassPathBeanDefinitionScanner {

    public SpringBaseBeanScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitions =   super.doScan(basePackages);
        return beanDefinitions;
    }


}
