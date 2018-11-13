package com.spring.cloud.mq.producer.controller;

import com.spring.cloud.mq.producer.producers.ProducerTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-activemq
 * @package: com.cy.sb.activemq.controller
 * @email: cy880708@163.com
 * @date: 2018/11/12 下午8:00
 * @mofified By:
 */
@RestController
@RequestMapping("/producer")
public class ProducersController {

    @Autowired
    ProducerTools producer;

    /**
     * @description：动态创建队列
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/13 下午2:18
     * @mofified By:
     */
    @RequestMapping("/send")
    public String send() {
        producer.send();
        return "send success";
    }

}
