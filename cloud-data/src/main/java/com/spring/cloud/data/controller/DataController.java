package com.spring.cloud.data.controller;

import com.spring.cloud.common.context.UserContextHolder;
import com.spring.cloud.data.config.DataConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/insertCompany")
    public String insertCompany(){
    	return "新增";
    }

    @GetMapping("/findAllCompany")
    public String findAllCompany(){
        return "查询数据";
    }
}
