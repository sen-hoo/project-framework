package com.cc.springframework.base;

import com.cc.springframework.base.enhance.EnhanceFactoryBean;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * 被此扫描器扫描的java bean都会被代理日志增强
 *
 * @Description 增强包扫描器
 * @Author sen.hu
 * @Date 2018/11/26 16:40
 **/
public class EnhanceBeanScanner extends ClassPathBeanDefinitionScanner {
    public EnhanceBeanScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
        for (BeanDefinitionHolder holder : beanDefinitions) {
            GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();
            definition.getPropertyValues().add("innerClassName", definition.getBeanClassName());
            definition.setBeanClass(EnhanceFactoryBean.class);
        }
        return beanDefinitions;
    }
}
