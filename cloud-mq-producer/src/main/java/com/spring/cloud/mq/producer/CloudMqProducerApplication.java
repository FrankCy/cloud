package com.spring.cloud.mq.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

/**
 * @description：队列启动
 * @version 1.0
 * @author: Yang.Chang
 * @email: cy880708@163.com
 * @date: 2018/11/13 下午2:57
 * @mofified By:
 */
@Slf4j
@SpringBootApplication
public class CloudMqProducerApplication {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("com.cy.sb.activemq.queue");
//		return new ActiveMQQueue("*");
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudMqProducerApplication.class, args);
	}
}
