package com.cc.springweb.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @Description 测试接口类
 * @Author sen.hu
 * @Date 2018/12/29 18:05
 **/
@RestController
@RequestMapping(value = "test")
public class TestController {


    @RequestMapping(value = "retstr", produces = {"text/plain;charset=UTF-8"})
    public String test() {
        return "hello word";
    }

    @RequestMapping(value = "retobj", produces = {"application/json; charset=UTF-8"})
    public Object testRetObj() {
//        List<Integer> data = new ArrayList<>(10);
//        System.out.println(data.size());
        List<Integer> data = null;
        Map<String, Object> ret = new HashMap<>();
        ret.put("userName", "cc");
        ret.put("age", 18);
        ret.put("data", data);
        return ret;
    }

    @RequestMapping(value = "async")
    public Callable<String> asyncTest() {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(60 * 1000);
                return "OK";
            }
        };
    }

}

