package com.spring.cloud.client.admin.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.client.admin.controller.controller、
 * @email: cy880708@163.com
 * @date: 2018/11/29 下午3:03
 * @mofified By:
 */
@Controller
@RequestMapping
public class UserController {

    @RequestMapping(value = "/userIndex")
    public String index(Model model) {
        return "page/user/userIndex";
    }

}
