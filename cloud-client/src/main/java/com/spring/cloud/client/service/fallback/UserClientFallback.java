package com.spring.cloud.client.service.fallback;


import com.spring.cloud.client.service.dataservcie.DataService;
import org.springframework.stereotype.Component;

/**
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
