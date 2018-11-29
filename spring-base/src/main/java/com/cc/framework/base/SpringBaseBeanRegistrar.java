package com.cc.framework.base;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description bean注册到spring容器
 * @Author sen.hu
 * @Date 2018/11/27 10:53
 **/
public class SpringBaseBeanRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {

    private Logger logger = LoggerFactory.getLogger(SpringBaseBeanRegistrar.class);

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnableSpringBase.class.getName()));
        if (attributes.getBoolean("enabled")) {
            List<String> customerScanPackages = handlePackages(attributes.getStringArray("customerScanPackages"));
            customerScanPackages.add("com.cc.framework.base.scan");
            if (attributes.getBoolean("enableWebbase")) {
                customerScanPackages.add("com.cc.framework.web");
            }
            logger.debug("start initializing spring base beans");
            SpringBaseBeanScanner baseBeanScanner = new SpringBaseBeanScanner(registry);
            baseBeanScanner.doScan(customerScanPackages.toArray(new String[customerScanPackages.size()]));
            logger.debug("finish scan base packages" + JSON.toJSONString(customerScanPackages));
            List<String> enhancePackages = handlePackages(attributes.getStringArray("enhancePackages"));
            if (enhancePackages.size() > 0) {
                logger.debug("start scan enhance packages beans");
                EnhanceBeanScanner enhanceBeanScanner = new EnhanceBeanScanner(registry);
                enhanceBeanScanner.doScan(enhancePackages.toArray(new String[enhancePackages.size()]));
                logger.debug("finish enhance base packages" + JSON.toJSONString(enhancePackages));
            }
        }
    }

    private List<String> handlePackages(String ...packages) {
        List<String> packageList = new ArrayList<>();
        for (String s : packages) {
            if (!StringUtils.isEmpty(s))
                packageList.add(s);
        }
        return packageList;
    }

}
