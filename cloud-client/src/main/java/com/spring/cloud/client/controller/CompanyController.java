package com.spring.cloud.client.controller;

import com.spring.cloud.client.service.company.CompanyService;
import com.spring.cloud.common.base.Constants;
import com.spring.cloud.common.result.BdjrResult;
import com.spring.cloud.common.vo.CompanyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.client.controller、
 * @email: cy880708@163.com
 * @date: 2018/11/19 下午2:02
 * @mofified By:
 */
@RestController
public class CompanyController {

    @Autowired
    protected CompanyService companyService;

    /**
     * @description：新增用户信息x
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/14 下午1:52
     * @mofified By:
     */
    @RequestMapping(value = "/insertCompany", method = RequestMethod.POST)
    public BdjrResult addUser(CompanyUser companyUser){

        String insertCompayStr = companyService.insertCompany(companyUser);

        if(!StringUtils.isEmpty(insertCompayStr) && Constants.operaterSuccess.equals(insertCompayStr)) {
            return new BdjrResult.Builder<>().success("新增完毕").build();
        } else {
            return new BdjrResult.Builder<>().failure("新增失败").build();
        }

    }

}
