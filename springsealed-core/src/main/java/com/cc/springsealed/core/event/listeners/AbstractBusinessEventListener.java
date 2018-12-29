package com.cc.springsealed.core.event.listeners;

import com.cc.springsealed.core.event.BusinessEvent;
import com.cc.springsealed.core.event.BusinessStartEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Description 抽象业务事件监听器
 * @Author sen.hu
 * @Date 2018/12/29 16:38
 **/
public abstract class AbstractBusinessEventListener implements ApplicationListener<BusinessEvent> {

    @Override
    public void onApplicationEvent(BusinessEvent event) {
        if (event instanceof BusinessStartEvent) {
            //
            doOnBusinessStartEvent((BusinessStartEvent) event);
        } else {
            System.out.println("unknown business event...");
        }
    }

    /**
     * 业务启动事件
     * @param event 启动消息
     */
    public abstract void doOnBusinessStartEvent(BusinessStartEvent event);

}
