package com.spring.cloud.client.admin.controller.controller.index;

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
public class IndexController {

    /**
     * @description：访问首页
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/4 上午10:12
     * @mofified By:
     */
    @RequestMapping(value = "/index")
    public String index(Model model) {
        return "index";
    }

    /**
     * @description：访问主页
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/4 上午10:12
     * @mofified By:
     */
    @RequestMapping(value = "/main")
    public String main(Model model) {
        return "page/main";
    }

    /**
     * @description：
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/3 下午5:37
     * @mofified By:
     */
    @RequestMapping(value = "/userIndex")
    public String userIndex(Model model) {
        return "page/user/userList";
    }


}
