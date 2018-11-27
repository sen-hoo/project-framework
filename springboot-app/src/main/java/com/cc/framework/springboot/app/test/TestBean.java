package com.cc.framework.springboot.app.test;

import com.cc.springbase.enhance.ProxyEnhancer;
import org.springframework.stereotype.Component;

/**
 * @Description 测试代理增强
 * @Author sen.hu
 * @Date 2018/11/27 11:40
 **/
@Component
@ProxyEnhancer
public class TestBean {

    public void doOutput() {
        System.out.println("111111111111111111111");
    }

}
