package com.spring.cloud.data.config;

import com.spring.cloud.common.po.User;
import com.spring.cloud.common.po.UserWithBLOBs;
import com.spring.cloud.data.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.data.config、
 * @email: cy880708@163.com
 * @date: 2018/12/3 下午6:40
 * @mofified By:
 */
@Component
public class DataUserConfig {

    /**
     * 用户dao
     */
    @Autowired
    private UserMapper userMapper;

    public int insertUser(User user) {
        UserWithBLOBs userWithBLOBs = new UserWithBLOBs();
        BeanUtils.copyProperties(user, userWithBLOBs);
        return userMapper.insertSelective(userWithBLOBs);
    }

}
