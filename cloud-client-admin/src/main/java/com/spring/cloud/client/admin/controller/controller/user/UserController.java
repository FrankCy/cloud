package com.spring.cloud.client.admin.controller.controller.user;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.spring.cloud.client.admin.controller.service.UserService;
import com.spring.cloud.common.base.Constants;
import com.spring.cloud.common.po.Company;
import com.spring.cloud.common.po.UserWithBLOBs;
import com.spring.cloud.common.result.BdjrResult;
import com.spring.cloud.common.util.PageUtil;
import com.spring.cloud.common.util.StringUtil;
import com.spring.cloud.common.util.date.DateUtils;
import com.spring.cloud.common.vo.CompanyUser;
import com.spring.cloud.common.vo.DataResult;
import com.spring.cloud.common.vo.PageResult;
import com.spring.cloud.common.vo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.client.admin.controller.controller.user、
 * @email: cy880708@163.com
 * @date: 2018/12/3 下午5:14
 * @mofified By:
 */
@Controller
public class UserController {

    @Autowired
    protected UserService userService;

    /**
     * @description：查询用户信息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/3 下午5:15
     * @mofified By:
     */
    @RequestMapping(value = "/userList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String userList(Model model) {
        JSONArray jsonArray = new JSONArray();
        for(int i=0 ; i<10000; i++) {
            JSONObject jsonObject = new JSONObject();
            int y = i + 1;
            jsonObject.put("id", y);
            jsonObject.put("username", "用户名" + y);
            jsonObject.put("email", "邮箱" + y);
            jsonObject.put("nickname", "昵称" + y);
            jsonObject.put("registerTime", DateUtils.getDate());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString();
    }

    /**
     * @description：新增用户
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/3 下午6:23
     * @mofified By:
     */
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    @ResponseBody
    public BdjrResult insertUser(UserRole userRole) {
        //校验数据准确性
        userRole.setId((UUID.randomUUID().toString().replace("-","")));
        //调用新增服务
        String insertUserStr = userService.insertUser(userRole);

        if(!StringUtils.isEmpty(insertUserStr) && Constants.operaterSuccess.equals(insertUserStr)) {
            return new BdjrResult.Builder<>().success("新增成功").build();
        } else {
            return new BdjrResult.Builder<>().failure("新增失败").build();
        }
    }

    /**
     * @description：删除用户
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/4 下午1:19
     * @mofified By:
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public BdjrResult deleteUser(UserRole userRole) {
        //调用删除服务
        String deleteUserStr = userService.deleteUser(userRole);

        if(!StringUtils.isEmpty(deleteUserStr) && Constants.operaterSuccess.equals(deleteUserStr)) {
            return new BdjrResult.Builder<>().success("删除成功").build();
        } else {
            return new BdjrResult.Builder<>().failure("删除失败").build();
        }
    }

    /**
     * @description：修改用户信息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/4 下午1:33
     * @mofified By:
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public BdjrResult updateUser(UserRole userRole) {
        //调用修改服务
        String updateUserStr = userService.updateUser(userRole);

        if(!StringUtils.isEmpty(updateUserStr) && Constants.operaterSuccess.equals(updateUserStr)) {
            return new BdjrResult.Builder<>().success("修改成功").build();
        } else {
            return new BdjrResult.Builder<>().failure("修改失败").build();
        }
    }

    /**
     * @description：查询用户
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/4 下午1:53
     * @mofified By:
     */
    @RequestMapping(value = "/selectUser", method = RequestMethod.POST)
    @ResponseBody
    public BdjrResult selectUser(UserRole userRole) {
        //调用修改服务
        UserWithBLOBs userWithBLOBs = userService.selectUser(userRole);

        if(!StringUtils.isEmpty(userWithBLOBs)) {
            return new BdjrResult.Builder<>().success("查询成功", userWithBLOBs).build();
        } else {
            return new BdjrResult.Builder<>().failure("查询失败", "9568").build();
        }
    }

    /**
     * @description：查询用户信息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/4 下午2:19
     * @mofified By:
     */
    @RequestMapping(value = "/selectUsers", method = RequestMethod.POST)
    @ResponseBody
    public BdjrResult selectUsers(UserRole userRole,
                                  @RequestParam(defaultValue = "1") int offset,
                                  @RequestParam(defaultValue = "10")  int limit,
                                  @RequestParam(defaultValue = "createTime") String orderColumn,
                                  @RequestParam(defaultValue = "desc") String order){

        PageResult<UserWithBLOBs> users = userService.selectUsers(userRole, PageUtil.getPageNum(offset, limit), limit, StringUtil.camel2Underline(orderColumn), order);
        if(!StringUtils.isEmpty(users)) {
            return new BdjrResult.Builder<>().success("查询成功", users).build();
        } else {
            return new BdjrResult.Builder<>().failure("查询失败", "400").build();
        }
    }

}
