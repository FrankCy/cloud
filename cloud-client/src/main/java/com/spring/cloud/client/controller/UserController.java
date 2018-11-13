package com.spring.cloud.client.controller;


import com.spring.cloud.client.service.IUserService;
import com.spring.cloud.common.vo.ReqTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping(value = "/add")
//    public String add(HttpServletRequest request) {
//    public String add(ReqTest reqTest) {
//    public String add(Integer page, Integer rows) {
    public String add(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                      @RequestParam(value = "rows", defaultValue = "0", required = false) Integer rows) {

//        Integer page = reqTest.getPage();
//        Integer rows = reqTest.getRows();
//        String userid = reqTest.getUserid();

//        Integer page = request.getParameter("page") == null ? 0 : Integer.parseInt(request.getParameter("page"));
//        Integer rows = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
//        String userid = request.getParameter("userid") ;

        Integer sum;
        if(page == null || rows == null) {
            return "缺少参数";
        } else {
            sum = page + rows;
            logger.info("/add, result:" + sum);
        }

        return "相加的值是："  + sum.toString();
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
            logger.info(" 从缓存中获取了姓名 >> " + userName);
            return userName;
        }
        //缓存不存在，将数据存入缓存
        operations.set(key, name, 10, TimeUnit.SECONDS);
        logger.info("CityServiceImpl.findCityById() : 城市插入缓存 >>  " + name);

        return " Welcome: " + name;

    }

}
