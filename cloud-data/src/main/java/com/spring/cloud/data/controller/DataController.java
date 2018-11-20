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
 * @description：数据处理层
 * @version 1.0
 * @author: Yang.Chang
 * @email: cy880708@163.com
 * @date: 2018/11/20 上午11:08
 * @mofified By:
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

}
