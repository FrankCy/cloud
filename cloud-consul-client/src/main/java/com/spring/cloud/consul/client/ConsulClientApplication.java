package com.spring.cloud.consul.client;

import org.eclipse.jgit.internal.storage.reftree.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
public class ConsulClientApplication implements CommandLineRunner {

    @Autowired
    private ConsulDiscoveryClient consulDiscoveryClient;

    @Override
    public void run(String... args) throws Exception {
        List<ServiceInstance> serviceInstanceList = consulDiscoveryClient.getInstances("consul-server-1");
        ServiceInstance serviceInstance = serviceInstanceList.get(0);
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" +serviceInstance.getServiceId());

        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString()+"/hi",String.class);
        System.out.println(callServiceResult);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsulClientApplication.class, args);
    }

}
