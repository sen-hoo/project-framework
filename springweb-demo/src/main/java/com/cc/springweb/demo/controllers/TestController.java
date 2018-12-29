package com.cc.springweb.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 测试接口类
 * @Author sen.hu
 * @Date 2018/12/29 18:05
 **/
@RestController
@RequestMapping(value = "test")
public class TestController {


    @RequestMapping(value = "", produces = {"text/plain;charset=UTF-8"})
    public String test() {
        return "hello word";
    }

}
