package com.cc.springboot.app.service.impl;

import com.cc.springboot.app.service.BelleService;
import com.cc.springframework.base.enhance.ProxyEnhancer;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2018/11/27 11:41
 **/
@Service
@ProxyEnhancer
public class BelleServiceImpl implements BelleService {
    @Override
    public String genBelle() {
        return "this is a belle";
    }
}
