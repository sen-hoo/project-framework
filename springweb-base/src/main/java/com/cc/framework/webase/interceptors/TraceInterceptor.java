package com.cc.framework.webase.interceptors;

import com.cc.common.Constants;
import com.cc.utils.TraceUtil;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 拦截所有请求添加traceId
 * @Author sen.hu
 * @Date 2018/11/27 17:53
 **/
@Component
public class TraceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = request.getHeader(Constants.TRACE_ID_LOGWEB_HEADER);
        if (StringUtils.isEmpty(traceId)) {
            traceId = TraceUtil.genTraceId();
        }
        MDC.put(Constants.TRACE_ID_LOGFILE_NAME, traceId);
        return false;
    }
}
