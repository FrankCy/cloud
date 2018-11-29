package com.spring.cloud.client.service.impl;

import com.github.pagehelper.PageInfo;
import com.spring.cloud.client.service.company.CompanyService;
import com.spring.cloud.client.service.dataservcie.CompanyDataService;
import com.spring.cloud.common.po.Company;
import com.spring.cloud.common.vo.CompanyUser;
import com.spring.cloud.common.vo.DataResult;
import com.spring.cloud.common.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.client.service.impl
 * @email: cy880708@163.com
 * @date: 2018/11/15 下午1:46
 * @mofified By:
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDataService companyDataService;

    @Override
    public String insertCompany(CompanyUser companyUser) {
        // TODO 这里可以做客户端的逻辑处理
        return companyDataService.insertCompany(companyUser);
    }

    @Override
    public PageResult<Company> findAllCompany(int pageNum, int pageSize) {
        return companyDataService.findAllCompany();
    }

}
