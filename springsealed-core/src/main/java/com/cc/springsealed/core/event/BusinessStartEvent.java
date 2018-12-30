package com.cc.springsealed.core.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description 业务启动事件
 * @Author sen.hu
 * @Date 2018/12/29 16:33
 **/
public class BusinessStartEvent extends BusinessEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public BusinessStartEvent(Object source, String businessName) {
        super(source, businessName);
    }

}
