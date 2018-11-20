package com.spring.cloud.admin.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServerAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServerAdminApplication.class, args);
    }
}
