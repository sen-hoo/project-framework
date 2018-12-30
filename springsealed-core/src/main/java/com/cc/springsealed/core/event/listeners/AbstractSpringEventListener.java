package com.cc.springsealed.core.event.listeners;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Description spring容器抽象监听
 * @Author sen.hu
 * @Date 2018/12/29 17:19
 **/
public abstract class AbstractSpringEventListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            doOnContextRefreshed((ContextRefreshedEvent) event);
        }
    }

    /**
     *  容器刷新事件
     * @param event
     */
    public abstract void doOnContextRefreshed(ContextRefreshedEvent event);
}
