package com.cc.springapp.demo;

import com.cc.springsealed.core.event.BusinessStartEvent;
import com.cc.springsealed.core.event.listeners.AbstractBusinessEventListener;

/**
 * @Description 业务事件监听
 * @Author sen.hu
 * @Date 2018/12/29 16:56
 **/
public class DemoInit extends AbstractBusinessEventListener {

    @Override
    public void doOnBusinessStartEvent(BusinessStartEvent event) {
        System.out.println("业务启动");
    }
}
