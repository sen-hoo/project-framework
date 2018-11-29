package com.cc.framework.springboot.web.controllers;

import com.cc.common.ResultBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2018/11/29 18:40
 **/
@RestController
public class TestController {

    @RequestMapping(value = "test")
    public ResultBuilder.Result test1() {
        ResultBuilder.Result result = ResultBuilder.getSuccess();
        return result;
    }
}
