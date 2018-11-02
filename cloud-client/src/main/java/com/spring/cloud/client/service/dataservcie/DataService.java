package com.spring.cloud.client.service.dataservcie;


import com.spring.cloud.client.service.fallback.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * feign调用数据服务
 * @author yang.chang
 *
 */
@FeignClient(name = "cloud-data-server", fallback= UserClientFallback.class)
public interface DataService {
	
	@RequestMapping(value = "/getDefaultUser", method = RequestMethod.GET)
    public String getDefaultUser();
    
    @RequestMapping(value = "/getContextUserId", method = RequestMethod.GET)
    public String getContextUserId();

}
