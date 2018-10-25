package com.spring.cloud.consul.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RestController
public class ConsulClientApplication implements CommandLineRunner {

    @Autowired
    private ConsulDiscoveryClient consulDiscoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 从所有服务中选择一个服务（轮询）
     */
    @RequestMapping("/discover")
    public Object discover() {
        return loadBalancer.choose("consul-server-1").getUri().toString();
    }

    /**
     * 获取所有服务
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("consul-server-1");
    }

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
