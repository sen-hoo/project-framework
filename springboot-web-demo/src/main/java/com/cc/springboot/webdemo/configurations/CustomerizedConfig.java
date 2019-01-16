package com.cc.springboot.webdemo.configurations;

import com.cc.springsealed.webcore.advices.GloableExceptionAdvice;
import com.cc.springsealed.webcore.advices.TraceIdResponseAdvice;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @Description 用户自定义配置
 * @Author sen.hu
 * @Date 2019/1/16 15:52
 **/
@Configuration
public class CustomerizedConfig implements EnvironmentAware {

    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    //激活返归traceId建言
    @Bean
    public TraceIdResponseAdvice traceIdResponseAdvice() {
        return new TraceIdResponseAdvice();
    }
    //激活全局异常拦截器
    @Bean
    public GloableExceptionAdvice globalExceptionAdvice() {
        return new GloableExceptionAdvice();
    }

}
