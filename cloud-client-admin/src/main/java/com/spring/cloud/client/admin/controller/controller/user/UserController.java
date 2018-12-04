package com.spring.cloud.client.admin.controller.controller.user;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.spring.cloud.client.admin.controller.service.UserService;
import com.spring.cloud.common.base.Constants;
import com.spring.cloud.common.result.BdjrResult;
import com.spring.cloud.common.util.date.DateUtils;
import com.spring.cloud.common.vo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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


        //调用新增服务
        String insertUserStr = userService.insertUser(userRole);

        if(!StringUtils.isEmpty(insertUserStr) && Constants.operaterSuccess.equals(insertUserStr)) {
            return new BdjrResult.Builder<>().success("新增完毕").build();
        } else {
            return new BdjrResult.Builder<>().failure("新增失败").build();
        }
    }

}
