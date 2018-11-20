package com.spring.cloud.data.config;

import com.spring.cloud.data.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: yang.chang
 * @description : 配置信息
 */
@Component
@ConfigurationProperties(prefix = "com.spring.cloud.data")
public class DataConfig {

    private String defaultUser;

    @Autowired
	private CompanyDao companyDao;

	public String getDefaultUser() {
		return defaultUser;
	}

	public void setDefaultUser(String defaultUser) {
		this.defaultUser = defaultUser;
	}

}
