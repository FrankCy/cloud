package com.spring.cloud.data.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: yang.chang
 * @description : 配置信息
 */
@Component
@ConfigurationProperties(prefix = "com.spring.cloud")
public class DataConfig {

    private String defaultUser;

	public String getDefaultUser() {
		return defaultUser;
	}

	public void setDefaultUser(String defaultUser) {
		this.defaultUser = defaultUser;
	}
    
}
