package com.spring.cloud.data.config;

import com.github.pagehelper.Page;
import com.spring.cloud.common.po.Company;
import com.spring.cloud.common.vo.PageResult;
import com.spring.cloud.data.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.data.config、
 * @email: cy880708@163.com
 * @date: 2018/11/20 上午11:14
 * @mofified By:
 */
@Component
@ConfigurationProperties(prefix = "com.spring.cloud.data")
public class DataCompanyConfig {

    /**
     * 公司查询dao
     */
    @Autowired
    private CompanyDao companyDao;

    public int insertCompany(Company company) {
        return companyDao.insertCompany(company);
    }

    /**
     * @description：查询公司列表
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/29 上午10:38
     * @mofified By:
     */
    public PageResult<Company> findAllCompany() {
        Page<Company> companies = companyDao.findAllCompany();
        return PageResult.getPageResult(companies);
    }

}
