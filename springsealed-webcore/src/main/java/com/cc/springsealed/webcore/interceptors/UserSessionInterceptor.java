package com.cc.springsealed.webcore.interceptors;

import com.cc.springsealed.webcore.common.UserBaseSession;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2019/2/20 16:24
 **/
public class UserSessionInterceptor implements HandlerInterceptor {

    private UserSessionHandler userSessionHandler;

    public UserSessionInterceptor(UserSessionHandler userSessionHandler) {
        this.userSessionHandler = userSessionHandler;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }

    public interface UserSessionHandler {
        /**
         *  获取缓存session放入contenxt类中
         * @param request
         * @return
         */
        UserBaseSession getUserSession(HttpServletRequest request);
    }


}
