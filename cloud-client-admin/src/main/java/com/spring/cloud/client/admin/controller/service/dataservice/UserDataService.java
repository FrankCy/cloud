package com.spring.cloud.client.admin.controller.service.dataservice;

import com.spring.cloud.client.admin.controller.service.fallback.UserClientFallback;
import com.spring.cloud.common.vo.UserRole;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.client.admin.controller.service.dataservice、
 * @email: cy880708@163.com
 * @date: 2018/12/3 下午6:34
 * @mofified By:
 */
@FeignClient(name = "cloud-data-server", fallback= UserClientFallback.class)
public interface UserDataService {

    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    String insertUser(UserRole userRole);

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    String deleteUser(UserRole userRole);

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    String updateUser(UserRole userRole);

}
