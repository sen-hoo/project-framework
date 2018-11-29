package com.cc.framework.web.mvc;

import com.cc.common.Constants;
import com.cc.common.ResultBuilder;
import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Description 拦截controller设置返回traceId
 * @Author sen.hu
 * @Date 2018/11/29 18:33
 **/
@RestControllerAdvice
public class TraceResponseAdvice implements ResponseBodyAdvice<ResultBuilder.Result> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Nullable
    @Override
    public ResultBuilder.Result beforeBodyWrite(@Nullable ResultBuilder.Result body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body != null) {
            body.setTraceId(MDC.get(Constants.TRACE_ID_LOGFILE_NAME));
        }
        return body;
    }
}
