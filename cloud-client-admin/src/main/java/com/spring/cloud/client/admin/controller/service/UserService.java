package com.spring.cloud.client.admin.controller.service;

import com.spring.cloud.common.vo.UserRole;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.client.admin.controller.service、
 * @email: cy880708@163.com
 * @date: 2018/12/3 下午6:25
 * @mofified By:
 */
public interface UserService {

    /**
     * @description：创建用户信息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/3 下午6:31
     * @mofified By:
     */
    String insertUser(UserRole userRole);

}
