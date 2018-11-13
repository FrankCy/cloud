package com.spring.cloud.mq.producer.producers;

import com.spring.cloud.common.util.date.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.mq.producer.producers
 * @email: cy880708@163.com
 * @date: 2018/11/13 下午2:23
 * @mofified By:
 */
@Slf4j
@Component
@EnableScheduling
public class ProducerTools {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    /**
     * @description：创建send
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/12 下午7:56
     * @mofified By:
     */
    public void send() {
        //修改投资表
        //修改用户信息
        //修改余额
        System.out.println(DateUtils.getDate() + " ： 客户端创建的队列");
        this.jmsMessagingTemplate.convertAndSend(this.queue, "hi,客户端创建的队列");
    }


    /**
     * @description：每3s执行1次
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/12 下午7:56
     * @mofified By:
     */
    @Scheduled(fixedDelay = 3000)
    public void ScheduledThree() {
        System.out.println(DateUtils.getDate() + " ： 每隔3秒自动创建的队列");
        this.jmsMessagingTemplate.convertAndSend(this.queue, "hi,每隔3秒自动创建的队列");
    }
}
