package com.cc.framework.springboot.web;

import com.cc.framework.base.EnableSpringBase;
import com.cc.framework.web.mvc.interceptors.TraceInterceptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Description web空工程
 * @Author sen.hu
 * @Date 2018/11/26 11:38
 **/
@SpringBootApplication(scanBasePackages = {"com.cc.framework.springboot.web", "com.cc.framework.web.mvc"})
@EnableSpringBase
public class WebAppBoot {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(WebAppBoot.class, args);
        System.out.println(applicationContext.getParentBeanFactory());
        //context中使用beanfactory
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)applicationContext.getAutowireCapableBeanFactory();
        System.out.println(applicationContext.getBean(TraceInterceptor.class));
    }

}

