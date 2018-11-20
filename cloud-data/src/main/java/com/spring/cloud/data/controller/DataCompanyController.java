package com.spring.cloud.data.controller;

import com.spring.cloud.common.po.Company;
import com.spring.cloud.common.vo.CompanyUser;
import com.spring.cloud.data.config.DataCompanyConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.data.controller、
 * @email: cy880708@163.com
 * @date: 2018/11/20 上午11:09
 * @mofified By:
 */
@RestController
public class DataCompanyController {

    @Autowired
    private DataCompanyConfig dataCompanyConfig;

    @RequestMapping(value = "/insertCompany", method = RequestMethod.GET)
    public String insertCompany(CompanyUser companyUser, HttpServletRequest request){
        String token = request.getHeader("oauthToken");
        System.out.println("insertCompany token : " + token);

        Company company = new Company();
//        company.setcName("测试用户");
//        company.setcCode("测试编码");
//        company.setcDes("测试描述");

        //将VO内相同的值放到PO内
        BeanUtils.copyProperties(companyUser, company);
        int i = dataCompanyConfig.insertCompany(company);
        System.out.println("i : " + i);

        return "创建成功 ： " + i;
    }

    @GetMapping("/findAllCompany")
    public String findAllCompany(){
        return "查询数据";
    }

}
