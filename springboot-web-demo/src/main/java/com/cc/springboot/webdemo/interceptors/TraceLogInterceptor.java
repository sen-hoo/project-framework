package com.cc.springboot.webdemo.interceptors;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description 日志切面
 * @Author sen.hu
 * @Date 2019/1/16 14:27
 **/
@Component
@Order(1)
@Aspect
public class TraceLogInterceptor {

    private Logger logger = LoggerFactory.getLogger(TraceLogInterceptor.class);

    @Pointcut(value = "execution(public * com.cc.springboot.webdemo.controllers..*.*(..))")
    public void controllerLog() { }

    @Before(value = "controllerLog()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info(String.format("IP:%s\t URL:%s\t Method_Type: %s\t Execute_Method: %s\t Args: %s",
                request.getRemoteAddr(),
                request.getRequestURI().toString(),
                request.getMethod(),
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())
                ));
    }

    @AfterReturning(value = "controllerLog()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info(String.format("Method_Return:%s", JSON.toJSONString(result)));
    }

    @After(value = "controllerLog()")
    public void after(JoinPoint joinPoint) {

    }

    /**
     * 需要手动调用joint执行
     */

//    @Around(value = "controllerLog()")
//    public void around(JoinPoint joinPoint) {
//
//    }

    @AfterThrowing(pointcut = "controllerLog()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {

    }

}
