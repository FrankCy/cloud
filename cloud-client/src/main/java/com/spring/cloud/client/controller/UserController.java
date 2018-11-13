package com.spring.cloud.client.controller;


import com.spring.cloud.client.service.IUserService;
import com.spring.cloud.common.vo.User;
import com.sun.tools.corba.se.idl.InterfaceGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@Autowired
    protected RedisTemplate redisTemplate;
	
	/**
	 * 获取配置文件中系统默认用户
	 * @return
	 */
    @GetMapping("/getDefaultUser")
    public String getDefaultUser(){
        return userService.getDefaultUser();
    }
    
    /**
     * 获取上下文用户
     * @return
     */
    @GetMapping("/getContextUserId")
    public String getContextUserId(){
        return userService.getContextUserId();
    }
    
    /**
     * 获取供应商数据
     * @return
     */
    @GetMapping("/getProviderData")
    public List<String> getProviderData(){
        return userService.getProviderData();
    }

    /**
     * @description：添加缓存
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/13 下午4:27
     * @mofified By:
     */
    @RequestMapping(value = "/add" ,method=RequestMethod.GET)
    public String add(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows ) {
        return "page："  + page + " —— rows :" + rows;
    }

    /**
     * @description：请求接口，先查询缓存
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/11/13 下午4:28
     * @mofified By:
     */
    @GetMapping("/hello")
    public String sayHi(@RequestParam String name) {

        //从缓存中获取城市信息
        String key = name;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        //缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            String userName = operations.get(key);
            logger.info(" get redis username >> " + userName);
            return "get username " + userName;
        } else {
            //初始化缓存
            operations.set(key, name, 10, TimeUnit.SECONDS);
            logger.info(" set redis username >>  " + name);
            return " set username: " + name;
        }
    }

}
