package com.cc.framework.web.mvc;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.cc.framework.web.mvc.interceptors.TraceInterceptor;
import com.cc.framework.web.mvc.version.VersionRequestMappingHandlerMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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
}
