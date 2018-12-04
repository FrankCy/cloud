package com.spring.cloud.client.admin.controller.controller.main;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.spring.cloud.common.util.date.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.client.admin.controller.controller.main、
 * @email: cy880708@163.com
 * @date: 2018/12/3 下午3:06
 * @mofified By:
 */
@Controller
public class MainController {

    /**
     * @description：查询主页信息，组装json响应
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/12/3 下午3:06
     * @mofified By:
     */
    @RequestMapping(value = "/mainList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String mainList(Model model) {
        JSONArray jsonArray = new JSONArray();
        for(int i=0 ; i<10000; i++) {
            JSONObject jsonObject = new JSONObject();
            int y = i + 1;
            jsonObject.put("newsId", y);
            jsonObject.put("newsName", "css3用transition实现边框动画效果" + y);
            jsonObject.put("newsAuthor", "测试信息" + y);
            jsonObject.put("newsStatus", "审核通过" + y);
            jsonObject.put("newsLook", "开放浏览" + y);
            jsonObject.put("isShow", "isShow" + y);
            jsonObject.put("newsTime", DateUtils.getDate());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString();
    }

}
