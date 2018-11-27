package com.cc.springbase.scan.events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description application 时间监听
 * @Author sen.hu
 * @Date 2018/11/26 14:58
 **/
@Component
public class ApplicationEventListener implements ApplicationListener<ApplicationEvent> {

    private static List<EventCallback> contextStaredCallbackList = new ArrayList<>();
    private static List<EventCallback> contextRefreshedCallbackList = new ArrayList<>();

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextStartedEvent) {//容器启动
            ContextStartedEvent contextStartedEvent = (ContextStartedEvent) event;
            doCallback(contextStartedEvent.getApplicationContext(), contextStaredCallbackList);
        } else if (event instanceof ContextRefreshedEvent) {//容器刷新
            ContextRefreshedEvent refreshedEvent = (ContextRefreshedEvent) event;
            if (refreshedEvent.getApplicationContext().getParent() == null)
                doCallback(refreshedEvent.getApplicationContext(), contextRefreshedCallbackList);
        }
    }

    private void doCallback(ApplicationContext applicationContext, List<EventCallback> callbacks) {
        callbacks.forEach(one -> {
            try {
                one.whenTriggered(applicationContext);
            } catch (Exception e) {
            }
        });
    }

    public static void registerEventCallBack(EventCallback eventCallBack) {
        switch (eventCallBack.getEventType()) {
            case ContextStarted:
                contextStaredCallbackList.add(eventCallBack);
                break;
            case ContextRefreshed:
                contextRefreshedCallbackList.add(eventCallBack);
                break;
                default:
                    return;
        }
    }


}
