package com.cc.springweb.demo.view;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Description 自定义的视图解析器
 * @Author sen.hu
 * @Date 2019/1/2 15:21
 **/
@Component
public class MyViewResolver implements View {

    @Nullable
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(@Nullable Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("CustomViewResolver order 越小优先级越高！ 所以优先于 InternalResourceViewResolver");
    }
}
