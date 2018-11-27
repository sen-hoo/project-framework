package com.cc.springframework.base.scan.events;

import org.springframework.context.ApplicationContext;

/**
 * @Description 容器时间监听回调
 * @Author sen.hu
 * @Date 2018/11/26 14:57
 **/
public abstract class EventCallback {

    private EventType eventType;

    public EventCallback(EventType eventType) {
        this.eventType = eventType;
    }

    public abstract void whenTriggered(ApplicationContext context);

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
