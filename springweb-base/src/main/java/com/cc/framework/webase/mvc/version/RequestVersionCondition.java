package com.cc.framework.webase.mvc.version;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Author sen.hu
 * @Date 2018/11/29 17:44
 **/
public class RequestVersionCondition implements RequestCondition<RequestVersionCondition> {

    private static final Pattern VERSION_PATTERN = Pattern.compile("v([1-9]\\.[0-9])");

    private float version;

    public RequestVersionCondition(float version) {
        this.version = version;
    }

    public float getVersion() {
        return version;
    }

    @Override
    public RequestVersionCondition combine(RequestVersionCondition other) {
        return new RequestVersionCondition(other.getVersion());
    }

    @Nullable
    @Override
    public RequestVersionCondition getMatchingCondition(HttpServletRequest request) {
        Matcher m = VERSION_PATTERN.matcher(request.getPathInfo());
        if (m.find()) {
            float reqVersion = Float.valueOf(m.group(1));
            //如果请求版本号>=配置版本号
            if (reqVersion >= this.version) {
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(RequestVersionCondition other, HttpServletRequest request) {
        float diff = other.getVersion() - this.getVersion();
        if (diff > 0) { return 1; }
        else if (diff == 0) { return 0; }
        else { return -1; }
    }
}
