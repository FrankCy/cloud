package com.spring.cloud.data.controller;

import com.spring.cloud.common.base.Constants;
import com.spring.cloud.common.po.Company;
import com.spring.cloud.common.vo.CompanyUser;
import com.spring.cloud.common.vo.PageResult;
import com.spring.cloud.data.config.DataCompanyConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public String insertCompany(CompanyUser companyUser){

        //声明实体对象
        Company company = new Company();

        //将VO内相同的值放到PO内
        BeanUtils.copyProperties(companyUser, company);

        //判断并响应结果
        if(dataCompanyConfig.insertCompany(company) > 0) {
            return Constants.operaterSuccess;
        } else  {
            return Constants.operaterError;
        }
    }

    @GetMapping("/findAllCompany")
    public PageResult<Company> findAllCompany(){
        PageResult<Company> companyList = dataCompanyConfig.findAllCompany();
        return companyList;
    }

}
