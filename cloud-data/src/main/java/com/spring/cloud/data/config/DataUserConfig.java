package com.spring.cloud.data.config;

import com.github.pagehelper.Page;
import com.spring.cloud.common.po.User;
import com.spring.cloud.common.po.UserWithBLOBs;
import com.spring.cloud.common.vo.PageBean;
import com.spring.cloud.common.vo.PageResult;
import com.spring.cloud.common.vo.UserRole;
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

    public int deleteUser(String id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public int updateUser(UserWithBLOBs userWithBLOBs) {
        return userMapper.updateByPrimaryKeySelective(userWithBLOBs);
    }

    public UserWithBLOBs selectById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public PageResult<UserWithBLOBs> selectUsers(UserRole userRole, PageBean pageBean) {
        Page userPage = userMapper.selectByPageNumSize(userRole, pageBean.getPageNum(), pageBean.getPageSize(), pageBean.getOrderName(), pageBean.getOrderType());
        if(userPage.size() > 0) {
            return PageResult.getPageResult(userPage);
        } else {
            return null;
        }
    }

}
