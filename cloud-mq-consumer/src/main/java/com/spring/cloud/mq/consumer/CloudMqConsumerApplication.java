package com.spring.cloud.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description：启动类
 * @version 1.0
 * @author: Yang.Chang
 * @email: cy880708@163.com
 * @date: 2018/11/13 下午2:28
 * @mofified By:
 */
@Slf4j
@SpringBootApplication
public class CloudMqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMqConsumerApplication.class, args);
    }
}
