package com.spring.cloud.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 数据服务
 * @author yang.chang
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CloudDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudDataApplication.class, args);
	}
}
