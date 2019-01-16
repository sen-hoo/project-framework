package com.cc.springboot.webdemo.controllers;

import com.cc.common.ResultBuilder;
import com.cc.springsealed.webcore.version.RequestVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @Description 测试controller
 * @Author sen.hu
 * @Date 2019/1/16 13:42
 **/
@RestController
@RequestMapping(value = "test/{v}")
public class TestController {

    @RequestMapping(value = "retobj")
    @RequestVersion(vNo = 1.0F)
    public ResultBuilder.Result testRetObjV1() {
        return ResultBuilder.getSuccess();
    }

    @RequestMapping(value = "retobj")
    @RequestVersion(vNo = 1.1F)
    public ResultBuilder.Result testRetObjV2() {
        return ResultBuilder.getBaseBusinessException("test version");
    }
    @RequestMapping(value = "ex")
    @RequestVersion(vNo = 1.0F)
    public ResultBuilder.Result testGlobalException() throws Exception {
        throw new Exception("test");
        //return ResultBuilder.getSuccess();
    }

    @RequestMapping(value = "async")
    @RequestVersion(vNo = 1.0F)
    public Callable<ResultBuilder.Result> testAsync() {
        return new Callable<ResultBuilder.Result>() {
            @Override
            public ResultBuilder.Result call() throws Exception {
                Thread.sleep(5 * 1000);
                return ResultBuilder.getSuccess();
            }
        };
    }

}
