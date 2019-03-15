package com.cc.springsealed.webcore.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description 增加web mvc基础配置
 * @Author sen.hu
 * @Date 2018/11/28 17:28
 **/
public class BaseWebMvcConfig extends WebMvcConfigurationSupport{

//    @Bean
//    @Override
//    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
//        VersionRequestMappingHandlerMapping requestMappingHandlerMapping = new VersionRequestMappingHandlerMapping();
//        requestMappingHandlerMapping.setOrder(0);
//        requestMappingHandlerMapping.setInterceptors(getInterceptors());
//        return requestMappingHandlerMapping;
//    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                // 保留map空的字段
                SerializerFeature.WriteMapNullValue,
                // 将String类型的null转成""
                //SerializerFeature.WriteNullStringAsEmpty,
                // 将Number类型的null转成0
                //SerializerFeature.WriteNullNumberAsZero,
                // 将List类型的null转成[]
                SerializerFeature.WriteNullListAsEmpty,
                // 将Boolean类型的null转成false
                //SerializerFeature.WriteNullBooleanAsFalse,
                // 避免循环引用
                SerializerFeature.DisableCircularReferenceDetect
        );
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        List<MediaType> mediaTypeList = new ArrayList<>();
        // 解决中文乱码问题，相当于在Controller上的@RequestMapping中加了个属性produces = "application/json"
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypeList);
        converters.add(converter);
    }

//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(traceInterceptor)
//                .addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }

    /**
     * mvc异步调用配置
     * @param configurer
     */
    @Override
    protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
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
        mvcThreadPool.initialize();
        //执行线程池
        configurer.setTaskExecutor(mvcThreadPool);
        //退出时间
        configurer.setDefaultTimeout(15 * 1000);
    }

    /**
     * 全局设置跨域问题，还可以是用@CrossOrigin注解进行细粒度配置
     * @param registry
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
