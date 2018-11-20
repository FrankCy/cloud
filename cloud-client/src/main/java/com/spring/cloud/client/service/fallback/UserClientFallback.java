package com.spring.cloud.client.service.fallback;


import com.spring.cloud.client.service.dataservcie.DataService;
import org.springframework.stereotype.Component;

/**
 * @description：用户客户端熔断器
 * @version 1.0
 * @author: Yang.Chang
 * @email: cy880708@163.com
 * @date: 2018/11/19 下午4:12
 * @mofified By:
 */
@Component
public class UserClientFallback implements DataService {
	
	@Override
	public String getDefaultUser() {
		return new String("get getDefaultUser failed");
	}

	@Override
	public String getContextUserId() {
		return new String("get getContextUserId failed");
	}
	
}
