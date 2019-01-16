package com.cc.springboot.webdemo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description 异步任务配置
 * @Author sen.hu
 * @Date 2019/1/16 17:28
 **/
@EnableAsync
@Configuration
public class AsyncConfig {

    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor mvcThreadPool = new ThreadPoolTaskExecutor();
        //核心线程数
        mvcThreadPool.setCorePoolSize(2000);
        //线程总数
        mvcThreadPool.setMaxPoolSize(3000);
        //线程执行最长时间
        mvcThreadPool.setKeepAliveSeconds(15);
        //队列长度
        mvcThreadPool.setQueueCapacity(1000);
        //设置执行名称
        mvcThreadPool.setThreadNamePrefix("mvcAsync-");
        //设置拒绝策略
        mvcThreadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return mvcThreadPool;
    }

}
