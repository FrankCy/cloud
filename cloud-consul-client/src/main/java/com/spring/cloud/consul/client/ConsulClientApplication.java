package com.spring.cloud.consul.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.consul.client
 * @email: cy880708@163.com
 * @date: 2018/10/25 下午5:54
 * @mofified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulClientApplication{

    public static void main(String[] args) {
        SpringApplication.run(ConsulClientApplication.class, args);
    }

}
