package com.cc.springbase;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2018/11/26 16:40
 **/
public class EnhanceBeanScanner extends ClassPathBeanDefinitionScanner {
    public EnhanceBeanScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}
