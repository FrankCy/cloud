package com.spring.cloud.client.admin.controller.service;

import com.spring.cloud.common.po.UserWithBLOBs;
import com.spring.cloud.common.vo.PageResult;
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

    /**
     * @description：删除用户
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/4 下午1:21
     * @mofified By:
     */
    String deleteUser(UserRole userRole);

    /**
     * @description：修改用户
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/4 下午1:34
     * @mofified By:
     */
    String updateUser(UserRole userRole);

    /**
     * @description：查询用户（ID）
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/4 下午1:57
     * @mofified By:
     */
    UserWithBLOBs selectUser(UserRole userRole);

    /**
     * @description：查询用户
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/4 下午1:57
     * @param userRole 查询实体
     * @param pageNum 第几页
     * @param pageSize 每页显示条目数
     * @param orderName 排序字段
     * @param orderType 排序方式 (asc / desc)
     * @mofified By:
     */
    PageResult<UserWithBLOBs> selectUsers(UserRole userRole, int pageNum, int pageSize, String orderName, String orderType);

}
