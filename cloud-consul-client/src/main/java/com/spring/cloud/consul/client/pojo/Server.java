package com.spring.cloud.consul.client.pojo;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.consul.client.pojo
 * @email: cy880708@163.com
 * @date: 2018/10/26 下午3:49
 * @mofified By:
 */
public class Server {
    private String ip;
    private int weight;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Server(String ip, int weight) {
        this.ip = ip;
        this.weight = weight;
    }

    public Server(String ip) {
        super();
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Server [ip=" + ip + ", weight=" + weight + "]";
    }

}
