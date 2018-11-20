package com.spring.cloud.app.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaServerAppApplication.class, args);
	}
}
