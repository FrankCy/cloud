package com.spring.cloud.mq.consumer.consumers;


import com.spring.cloud.common.util.date.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-activemq
 * @package: com.cy.sb.activemq.consumer
 * @email: cy880708@163.com
 * @date: 2018/11/12 下午7:24
 * @mofified By:
 */
@Slf4j
@Component
public class Consumer {

    @JmsListener(destination = "com.cy.sb.activemq.queue")
    public void receiveQueue(String text) {
        System.out.println(DateUtils.getDate() + " ———————— 获取了" + text);
    }


    @JmsListener(destination = "com.cy.sb.activemq.queue.two")
    public void receiveQueueTwo(String text) {
        System.out.println(DateUtils.getDate() + " ———————— 获取了" + text);
    }

}
