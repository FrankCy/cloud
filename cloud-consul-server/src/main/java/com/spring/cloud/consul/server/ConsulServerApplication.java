package com.spring.cloud.consul.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.consul.server
 * @email: cy880708@163.com
 * @date: 2018/10/25 下午5:39
 * @mofified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulServerApplication {

    @Value("${spring.application.name}")
    private String name;

    @Value("${server.port}")
    private int port;

    @RequestMapping(value = "/hi")
    public String hi(){

        return "hello world ! I'm :" + name + ":" + port;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsulServerApplication.class, args);
    }

}
