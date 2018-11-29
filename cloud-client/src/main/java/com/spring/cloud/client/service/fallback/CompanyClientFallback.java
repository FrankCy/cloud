package com.spring.cloud.client.service.fallback;

import com.spring.cloud.client.service.dataservcie.CompanyDataService;
import com.spring.cloud.common.po.Company;
import com.spring.cloud.common.vo.CompanyUser;
import com.spring.cloud.common.vo.DataResult;
import com.spring.cloud.common.vo.PageResult;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.client.service.fallback
 * @email: cy880708@163.com
 * @date: 2018/11/15 下午6:45
 * @mofified By:
 */
@Component
public class CompanyClientFallback implements CompanyDataService {

    @Override
    public String insertCompany(CompanyUser companyUser) {
        return new String("新增公司信息失败！FeignClient");
    }

    @Override
    public PageResult<Company> findAllCompany() {
        PageResult dataResult = new PageResult();
        return dataResult;
    }
}
