package com.spring.cloud.client.admin.controller.service.fallback;

import com.spring.cloud.client.admin.controller.service.dataservice.UserDataService;
import com.spring.cloud.common.po.UserWithBLOBs;
import com.spring.cloud.common.vo.UserRole;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.client.admin.controller.service.fallback、
 * @email: cy880708@163.com
 * @date: 2018/12/3 下午6:35
 * @mofified By:
 */
@Component
public class UserClientFallback implements UserDataService {

    @Override
    public String insertUser(UserRole userRole) {
        return "新增用户失败";
    }

    @Override
    public String deleteUser(UserRole userRole) {
        return "删除用户失败";
    }

    @Override
    public String updateUser(UserRole userRole) {
        return "修改用户失败";
    }

    @Override
    public UserWithBLOBs selectUser(UserRole userRole) {
        return null;
    }

}
