package com.cc.springapp.demo;

import com.cc.springsealed.core.event.BusinessEvent;
import com.cc.springsealed.core.event.BusinessStartEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 项目启动类
 * @Author sen.hu
 * @Date 2018/12/29 16:54
 **/
public class AppBoot {
    public static void main(String[] args) {
        //加载spring
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring-context.xml"});
        //发布业务事件
        context.publishEvent(new BusinessStartEvent(context, "demo-project"));
        //shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            //
            System.out.println("app shutdown");
        }));
    }
}
