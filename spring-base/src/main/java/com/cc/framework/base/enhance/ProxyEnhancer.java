package com.cc.framework.base.enhance;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ProxyEnhancer {
    boolean enabled() default true;
    EnhancerType[] enhancerTypes() default { EnhancerType.LogEnhancer };
}
