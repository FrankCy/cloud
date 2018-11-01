package com.spring.cloud.consul.client.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.consul.client.util
 * @email: cy880708@163.com
 * @date: 2018/10/26 下午3:52
 * @mofified By:
 */
public class PollingUtil {

    int currentIndex = 0;

    /**
     * @description：轮询
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/10/26 下午3:56
     * @mofified By:
     */
    public Object round(List servers) {
        int totalServer = servers.size();
        currentIndex = (currentIndex + 1) % totalServer;
        return servers.get(currentIndex);
    }

    public static Object randomServer(List servers) {
        Random random = new Random(servers.size());
        return random.nextInt();
    }


    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");

        PollingUtil pu = new PollingUtil();


        int r = 0;
        while (r < 10) {
            System.out.println(pu.round(strings));;
            r++;
        }
    }
}
