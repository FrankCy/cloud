package com.spring.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @description：熔断器启动程序
 * @version 1.0
 * @author: Yang.Chang
 * @email: cy880708@163.com
 * @date: 2018/11/13 下午3:25
 * @mofified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
@EnableHystrixDashboard
public class CloudHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixApplication.class, args);
    }
}
