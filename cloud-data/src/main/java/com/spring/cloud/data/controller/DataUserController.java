package com.spring.cloud.data.controller;

import com.spring.cloud.common.base.Constants;
import com.spring.cloud.common.po.User;
import com.spring.cloud.common.po.UserWithBLOBs;
import com.spring.cloud.common.vo.UserRole;
import com.spring.cloud.data.config.DataUserConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.data.controller、
 * @email: cy880708@163.com
 * @date: 2018/12/3 下午6:37
 * @mofified By:
 */
@RestController
public class DataUserController {

    @Autowired
    private DataUserConfig dataUserConfig;

    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    public String insertUser(UserRole userRole){

        //声明实体对象
        User user = new User();

        //将VO内相同的值放到PO内
        BeanUtils.copyProperties(userRole, user);
        user.setRegisterTime(userRole.getRegisterTime());

        //判断并响应结果
        if(dataUserConfig.insertUser(user) > 0) {
            return Constants.operaterSuccess;
        } else  {
            return Constants.operaterError;
        }
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(UserRole userRole){

        //获取用户逐渐
        String id = userRole.getId();

        //判断并响应结果
        if(dataUserConfig.deleteUser(id) > 0) {
            return Constants.operaterSuccess;
        } else  {
            return Constants.operaterError;
        }
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(UserRole userRole){

        //获取用户逐渐
        String id = userRole.getId();
        UserWithBLOBs userWithBLOBs = dataUserConfig.selectById(id);
        if(userWithBLOBs != null) {
            //判断并响应结果
            BeanUtils.copyProperties(userRole, userWithBLOBs);
            if(dataUserConfig.updateUser(userWithBLOBs) > 0) {
                return Constants.operaterSuccess;
            } else  {
                return Constants.operaterError;
            }
        } else {
            return Constants.operaterError;
        }

    }

    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
    public UserWithBLOBs selectUser(UserRole userRole){
        //获取用户逐渐
        String id = userRole.getId();
        UserWithBLOBs userWithBLOBs = dataUserConfig.selectById(id);
        if(userWithBLOBs != null) {
            return userWithBLOBs;
        } else {
            return null;
        }
    }

}
