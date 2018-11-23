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
 * @date: 2018/11/23 上午11:24
 * @mofified By:
 */
@Controller
@RequestMapping
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(Model model) {
        return "index";
    }

}
