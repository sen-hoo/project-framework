package com.cc.springbase.enhance;

import com.alibaba.fastjson.JSON;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2018/11/27 16:42
 **/
public class LogInfo {
    private String className;
    private String methodName;
    private Object[] params;
    private long costTime;
    private Object ret;

    public LogInfo(String className, String methodName, Object[] params, long costTime, Object ret) {
        this.className = className;
        this.methodName = methodName;
        this.params = params;
        this.costTime = costTime;
        this.ret = ret;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public long getCostTime() {
        return costTime;
    }

    public void setCostTime(long costTime) {
        this.costTime = costTime;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
