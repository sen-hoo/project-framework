package com.cc.framework.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        Pattern VERSION_PATTERN = Pattern.compile("v([1-9]\\.[0-9])");
        Matcher m = VERSION_PATTERN.matcher("/v1.2/test");
        System.out.println(m.find());
        System.out.println(m.group(1));
    }
}
