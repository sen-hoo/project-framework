package com.cc.springframework.webase.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2018/11/27 17:53
 **/
@Component
public class TraceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //TODO
//        String traceId = request.getHeader();
//        if (StringUtils.isEmpty(traceId))
//            traceId =
        return false;
    }
}
