package com.cc.springboot.app;

import com.cc.springboot.app.service.BelleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2018/11/26 11:37
 **/
@SpringBootApplication
public class AppBoot {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AppBoot.class, args);
//        TestBean testBean = context.getBean(TestBean.class);
//        testBean.doOutput();
        BelleService belleService = context.getBean(BelleService.class);
        System.out.println(belleService.genBelle());
    }

}
