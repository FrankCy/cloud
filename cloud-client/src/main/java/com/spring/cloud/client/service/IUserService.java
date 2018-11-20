package com.spring.cloud.client.service;


import java.util.List;

/**
 * @description：
 * @version 1.0
 * @author: Yang.Chang
 * @email: cy880708@163.com
 * @date: 2018/11/20 下午4:34
 * @mofified By:
 */
public interface IUserService {
    
    public String getDefaultUser();
    
    public String getContextUserId();
    
    public List<String> getProviderData();

}
