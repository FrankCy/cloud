package com.spring.cloud.zuul.config;

import com.spring.cloud.zuul.route.ZuulRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.zuul.config、
 * @email: cy880708@163.com
 * @date: 2018/12/7 上午10:47
 * @mofified By:
 */
//@Configuration
public class ZuulConfig {

    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties serverProperties;

    @Bean
    public ZuulRouteLocator routeLocator() {
        ZuulRouteLocator routeLocator = new ZuulRouteLocator(
                serverProperties.getServlet().getServletPrefix(), zuulProperties);
        return routeLocator;
    }

}
