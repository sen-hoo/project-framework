package com.cc.framework.springboot.web.controllers;

import com.cc.common.ResultBuilder;
import com.cc.framework.web.mvc.version.RequestVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2018/11/29 18:40
 **/
@RestController
@RequestMapping(value = "{v}")
public class TestController {

    @RequestMapping(value = "test")
    public ResultBuilder.Result test1() {
        ResultBuilder.Result result = ResultBuilder.getSuccess();
        return result;
    }

    @RequestVersion(vNo = 1.1F)
    @RequestMapping(value = "test")
    public ResultBuilder.Result test2() {
        ResultBuilder.Result result = ResultBuilder.getSuccess();
        return result;
    }
}
