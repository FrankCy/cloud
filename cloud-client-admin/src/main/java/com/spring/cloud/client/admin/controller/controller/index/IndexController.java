package com.spring.cloud.client.admin.controller.controller.index;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.spring.cloud.common.util.date.DateUtils;
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

    @RequestMapping(value = "/index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/main")
    public String main(Model model) {
        return "page/main";
    }

}
