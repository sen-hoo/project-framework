package com.cc.springboot.webdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Description demo启动类
 * @Author sen.hu
 * @Date 2019/1/16 13:41
 **/
@SpringBootApplication
public class WebDemoBoot {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(WebDemoBoot.class, args);
        System.out.println(context.getBean("threadPoolTaskExecutor"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            //添加shutdown hook
        }));
    }

}
