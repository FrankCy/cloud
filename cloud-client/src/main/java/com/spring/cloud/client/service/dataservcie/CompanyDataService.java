package com.spring.cloud.client.service.dataservcie;

import com.spring.cloud.client.service.fallback.CompanyClientFallback;
import com.spring.cloud.common.po.Company;
import com.spring.cloud.common.vo.CompanyUser;
import com.spring.cloud.common.vo.DataResult;
import com.spring.cloud.common.vo.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @version 1.0
 * @description：Feign调度
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.client.service.dataservcie
 * @email: cy880708@163.com
 * @date: 2018/11/15 下午6:44
 * @mofified By:
 */
@FeignClient(name = "cloud-data-server", fallback= CompanyClientFallback.class)
public interface CompanyDataService {

    @RequestMapping(value = "/insertCompany", method = RequestMethod.GET)
    String insertCompany(CompanyUser companyUser);

    @RequestMapping(value = "/findAllCompany", method = RequestMethod.GET)
    PageResult<Company> findAllCompany();

}
