package com.cc.springweb.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description 主控制器
 * @Author sen.hu
 * @Date 2018/12/29 17:59
 **/
@Controller
public class MainController {


    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView index = new ModelAndView("index");
        index.addObject("title", "springweb-demo");
        return index;
    }

}
