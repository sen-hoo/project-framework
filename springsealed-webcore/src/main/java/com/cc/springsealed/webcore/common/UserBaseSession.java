package com.cc.springsealed.webcore.common;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2019/2/20 16:20
 **/
public class UserBaseSession {

    private String token;
    private Object userId;
    private String userName;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
