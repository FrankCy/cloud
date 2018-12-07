package com.spring.cloud.zuul.route;

import com.spring.cloud.zuul.dao.ZuulRouteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.zuul.route、
 * @email: cy880708@163.com
 * @date: 2018/12/7 上午10:39
 * @mofified By:
 */
public class ZuulRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ZuulRouteDao zuulRouteDao;

    public ZuulRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
        this.zuulProperties = properties;
    }

    @Override
    public void refresh() {
        doRefresh();
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>();
        routesMap.putAll(super.locateRoutes());
        routesMap.putAll(zuulRouteDao.getProperties());
        LinkedHashMap<String, ZuulProperties.ZuulRoute> values = new LinkedHashMap<>();
        routesMap.forEach((key, value) -> {
            String path = key;
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            if (StringUtils.hasText(this.zuulProperties.getPrefix())) {
                path = this.zuulProperties.getPrefix() + path;
                if (!path.startsWith("/")) {
                    path = "/" + path;
                }
            }
            values.put(path, value);
        });
        return values;
    }

}
