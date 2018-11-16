package com.spring.cloud.data.dao;

import com.spring.cloud.common.po.Company;

import java.util.List;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.data.dao、
 * @email: cy880708@163.com
 * @date: 2018/11/16 下午1:29
 * @mofified By:
 */
public interface CompanyDao {

    /**
     * @description：新增
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/16 下午1:30
     * @mofified By:
     */
    int insertCompany(Company company);

    /**
     * @description：查询
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/16 下午1:30
     * @mofified By:
     */
    List<Company> findAllCompany();

}
