package com.spring.cloud.client.service.company;

import com.spring.cloud.common.po.Company;
import com.spring.cloud.common.vo.CompanyUser;
import com.spring.cloud.common.vo.PageResult;

/**
 * @version 1.0
 * @description：公司接口
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.client.service.company
 * @email: cy880708@163.com
 * @date: 2018/11/15 下午1:44
 * @mofified By:
 */
public interface CompanyService {

    /**
     * @description：创建公司信息
     * @version 1.0
     * @param companyUser 公司实体对象
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/15 下午1:50
     * @mofified By:
     */
    String insertCompany(CompanyUser companyUser);

    /**
     * @description：查询公司信息
     * @version 1.0
     * @param pageNum 第几页
     * @param pageSize 每页显示条目数
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/15 下午1:50
     * @mofified By:
     */
    PageResult<Company> findAllCompany(int pageNum, int pageSize);

}
