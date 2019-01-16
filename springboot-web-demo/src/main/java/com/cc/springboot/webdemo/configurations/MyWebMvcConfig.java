package com.cc.springboot.webdemo.configurations;

import com.cc.springsealed.webcore.config.BaseWebMvcConfig;
import com.cc.springsealed.webcore.interceptors.TraceIdInterceptor;
import com.cc.springsealed.webcore.version.VersionRequestMappingHandlerMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @Description mvc配置类，集成
 * @Author sen.hu
 * @Date 2019/1/16 13:46
 **/
@Component
public class MyWebMvcConfig extends BaseWebMvcConfig {

    //增加api 版本判断
    @Bean
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        VersionRequestMappingHandlerMapping versionMapping = new VersionRequestMappingHandlerMapping();
        versionMapping.setOrder(0);
        versionMapping.setInterceptors(getInterceptors());
        return versionMapping;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //添加traceId拦截器
        registry.addInterceptor(new TraceIdInterceptor())
                .addPathPatterns("/**")
        ;
        super.addInterceptors(registry);
    }
}
