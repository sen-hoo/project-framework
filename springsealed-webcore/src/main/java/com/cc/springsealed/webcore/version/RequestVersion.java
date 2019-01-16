package com.cc.springsealed.webcore.version;

import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping
public @interface RequestVersion {
    float vNo() default 1.0F;
}
