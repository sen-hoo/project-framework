package com.cc.framework.springboot.web;

import com.cc.framework.base.EnableSpringBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2018/11/26 11:38
 **/
@SpringBootApplication
@EnableSpringBase(enabled = true, enableWebbase = true)
public class WebAppBoot {

    public static void main(String[] args) {
        SpringApplication.run(WebAppBoot.class, args);
    }

}

