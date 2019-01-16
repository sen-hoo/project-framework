package com.cc.springsealed.webcore.interceptors;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description 调用日志切面拦截，打印调用日志
 * @Author sen.hu
 * @Date 2019/1/16 11:10
 **/
public class TraceLogInterceptor implements MethodInterceptor {

    private Logger logger = LoggerFactory.getLogger(TraceLogInterceptor.class);

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = methodProxy.invokeSuper(o, objects);
        logger.info(String.format("Class:%s\t Method: %s\t Args:%s \tResult:%s", o.getClass().getName(), method.getName(), JSON.toJSONString(objects), JSON.toJSONString(result)));
        return result;
    }
}
