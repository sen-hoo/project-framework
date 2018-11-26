package com.cc.springbase;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SpringBaseBeanScanner.class)
public @interface EnableSpringBase {
    String[] basePackages() default "com.cc.springbase";
    String[] enhancePackages();
}
