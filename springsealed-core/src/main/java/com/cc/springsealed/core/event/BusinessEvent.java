package com.cc.springsealed.core.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description 业务事件
 * @Author sen.hu
 * @Date 2018/12/29 16:39
 **/
public class BusinessEvent extends ApplicationEvent {

    private final String businessName;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public BusinessEvent(Object source, String businessName) {
        super(source);
        this.businessName = businessName;
    }
}
