package com.spring.cloud.common.context;

public class HystrixThreadLocal {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
}