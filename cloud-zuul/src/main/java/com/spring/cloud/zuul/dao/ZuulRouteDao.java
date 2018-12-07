package com.spring.cloud.zuul.dao;

import com.spring.cloud.zuul.po.ZuulRouteConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.zuul.dao、
 * @email: cy880708@163.com
 * @date: 2018/12/7 上午10:42
 * @mofified By:
 */
@Component
public class ZuulRouteDao {

    @Autowired
    private ZuulProperties properties;

    public Map<String, ZuulProperties.ZuulRoute> getProperties() {
        Map<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>();
        List<ZuulRouteConfig> zuulRouteConfigList = new ArrayList<>();
        //读取配置文件 / 缓存 / 数据库 等，根据项目实际需要，获取动态路由配置项
        ZuulRouteConfig zuulRouteConfig = new ZuulRouteConfig();
        zuulRouteConfig.setId((UUID.randomUUID().toString()).replace("-",""));
        zuulRouteConfig.setPath("/admin/**");
        zuulRouteConfig.setUrl("http://127.0.0.1:7777/admin");
        zuulRouteConfig.setStripPrefix(1);
        zuulRouteConfig.setRetryable(0);
        zuulRouteConfig.setEnabled(1);
        zuulRouteConfig.setDescription("后台管理程序");
        zuulRouteConfigList.add(zuulRouteConfig);

        ZuulRouteConfig zuulRouteConfig2 = new ZuulRouteConfig();
        zuulRouteConfig2.setId((UUID.randomUUID().toString()).replace("-",""));
        zuulRouteConfig2.setPath("/cloud-client-server/**");
        zuulRouteConfig2.setUrl("http://127.0.0.1:7777/cloud-client-server");
        zuulRouteConfig2.setStripPrefix(1);
        zuulRouteConfig2.setRetryable(0);
        zuulRouteConfig2.setEnabled(1);
        zuulRouteConfig2.setDescription("测试公司接口");
        zuulRouteConfigList.add(zuulRouteConfig2);

        LinkedHashMap<String, ZuulProperties.ZuulRoute> values = new LinkedHashMap<>();
        zuulRouteConfigList.forEach(entity -> {
            if (StringUtils.isEmpty(entity.getPath())) {
                return;
            } else {
                ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
                BeanUtils.copyProperties(entity, zuulRoute);
                routesMap.put(zuulRoute.getPath(), zuulRoute);
            }
        });

        return routesMap;
    }

    public static void main(String[] args) {
        ZuulRouteDao zuulRouteDao = new ZuulRouteDao();
        zuulRouteDao.getProperties();
    }

}
