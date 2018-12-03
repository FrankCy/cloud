package com.spring.cloud.data.config;

import com.spring.cloud.data.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description：配置信息
 * @version 1.0
 * @author: Yang.Chang
 * @email: cy880708@163.com
 * @date: 2018/11/29 下午2:10
 * @mofified By:
 */
@Component
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
