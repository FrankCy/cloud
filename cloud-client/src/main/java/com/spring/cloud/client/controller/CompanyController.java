package com.spring.cloud.client.controller;

import com.spring.cloud.client.service.company.CompanyService;
import com.spring.cloud.common.result.BdjrResult;
import com.spring.cloud.common.vo.CompanyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
        System.out.println("userName : " + companyUser.getUserName());
        System.out.println("companyCode : " + companyUser.getcCode());
        System.out.println("companyName : " + companyUser.getcName());
        System.out.println("companyDes : " + companyUser.getcDes());
        System.out.println(companyService.insertCompany(companyUser));

        return new BdjrResult.Builder<>().success("新增完毕").build();
    }

}
