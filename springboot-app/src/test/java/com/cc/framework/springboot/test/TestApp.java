package com.cc.framework.springboot.test;

import com.cc.framework.springboot.app.service.BelleService;
import com.cc.framework.springboot.app.service.impl.BelleServiceImpl;
import org.junit.Test;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2018/11/27 16:07
 **/
public class TestApp {

    @Test
    public void test1() {
        BelleService belleService = new BelleServiceImpl();
        System.out.println(belleService.getClass().getSuperclass());
    }

}
