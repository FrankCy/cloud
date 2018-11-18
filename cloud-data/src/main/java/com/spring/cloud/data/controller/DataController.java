package com.spring.cloud.data.controller;

import com.spring.cloud.common.context.UserContextHolder;
import com.spring.cloud.common.po.Company;
import com.spring.cloud.common.vo.CompanyUser;
import com.spring.cloud.data.config.DataConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yang.chang
 */
@RestController
public class DataController {
    
	@Autowired
	private DataConfig dataConfig;
	
    @GetMapping("/getContextUserId")
    public String getContextUserId(){
        return UserContextHolder.currentUser().getUserId();
    }
    
    @GetMapping("/getDefaultUser")
    public String getDefaultUser(){
        return dataConfig.getDefaultUser();
    }
    
    @GetMapping("/getProviderData")
    public List<String> getProviderData(){
    	List<String> provider = new ArrayList<String>();
    	provider.add("Beijing Company");
    	provider.add("Shanghai Company");
    	provider.add("Shenzhen Company");
        return provider;
    }

    @RequestMapping(value = "/insertCompany", method = RequestMethod.GET)
    public String insertCompany(CompanyUser companyUser, HttpServletRequest request){
        String token = request.getHeader("oauthToken");
        System.out.println("insertCompany token : " + token);

        Company company = new Company();
//        company.setcName("测试用户");
//        company.setcCode("测试编码");
//        company.setcDes("测试描述");

        //将VO内相同的值放到PO内
        BeanUtils.copyProperties(company, companyUser);
        int i = dataConfig.insertCompany(company);
        System.out.println("i : " + i);
    	return "创建成功 ： " + i;
    }

    @GetMapping("/findAllCompany")
    public String findAllCompany(){
        return "查询数据";
    }
}
