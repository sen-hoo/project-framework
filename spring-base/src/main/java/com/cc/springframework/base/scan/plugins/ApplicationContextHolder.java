package com.cc.springframework.base.scan.plugins;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description spring 上线文
 * @Author cc.hu
 * @Date 2018/11/26 14:46
 **/
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static <T> T getContainerBean(Class<T> clazz) {
        if (context != null)
            return context.getBean(clazz);
        return null;
    }

    public static Object getContainerBean(String name) {
        if (context != null)
            return context.getBean(name);
        return null;
    }
}
