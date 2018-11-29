package com.cc.framework.base;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SpringBaseBeanRegistrar.class)
public @interface EnableSpringBase {
    boolean enabled() default true;
    boolean enableWebbase() default false;
    //spring base所在位置
    String[] customerScanPackages() default "";
    //增强代理扫码
    String[] enhancePackages() default "";
}
