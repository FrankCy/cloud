## Spring Cloud 2.0+ #
#### 基于Spring Boot 2.0+ ####
### 简介 ####
一个简单的Spring Cloud基础框架，集成config／Eureka／Hystrix／ActiveMQ等组件
### 工程介绍 ###
工程|端口|描述
---|:--:|:---
cloud|N/A|父节点
cloud-client|9091|用户服务
cloud-client-admin|9092|后台管理程序
cloud-client-app|9093|手机应用程序接口
cloud-client-pc|9094|web客户端
cloud-client-partner|9095|与第三方交互客户端
cloud-common|N/A|公共组件
cloud-config-server|9090|配置中心
cloud-data|8099|数据服务，提供基础的数据
cloud-eureka-server|8761|注册中心
cloud-hystrix|9099|hystrix dashboard& Turbine
cloud-mq-producer|8077|ActiveMQ服务端
cloud-mq-consumer|8078|ActiveMQ消费端
cloud-zuul|7777|API GateWay

### 技术栈 ###
技术|版本|应用场景
---|:--:|:---
Spring Boot|2.0.3.RELEASE|基础平台
Spring Cloud Dependencies|Finchley.RELEASE|基础平台
Eureka|N/A|注册中心
Ribbon|N/A|客户端负载均衡
Config|N/A|配置中心
Zuul|N/A|网关
Hystrix|N/A|熔断器
ActiveMq|N/A|消息队列
Mybatis|N/A|数据库中间件
PageHelper|N/A|分页控件
LayUI|N/A|后台管理程序基础框架

### 示例图 ###
[Eureka + Ribbon + Config + Zuul + Hystrix 示例图点击查看](https://images.hzmedia.com.cn/xiandu/springcloud_921/Images/t10-1.jpg?v=20180921165736)

### 项目地址 ###
[GitHub](https://github.com/FrankCy/cloud.git)

### 启动说明 ###
- 建议流程启动顺序 <br/>
cloud-eureka-server -> cloud-zuul -> cloud-data -> cloud-client

- 请求拦截 <br/>
请求：[http://localhost:9091/add](http://localhost:9091/add) <br/>
系统并未响应任何信息，查看控制台报错<br/>
```the user is null, please access from gateway or check user info``` <br/>
这说明拦截器起到了作用，对于没有用户信息这样不合法的请求进行了拦截<br/>
再请求：[http://localhost:7777/cloud-client-server/getContextUserId](http://localhost:7777/cloud-client-server/getContextUserId) <br/>
```{"businessId":1,"exceptionType":"com.spring.cloud.common.exception.BaseException","code":10001,"businessMessage":"the user is null, please check","codeEN":"AuthEmptyError"}``` <br/>
这是自定义了一个异常，没有传用户信息，因为这里在网关做了拦截，如果请求头里没有user_key则鉴权不通过<br/><br/>
Client(Controller) --> Client(Services) 这里@Autowired DataService --> DataService通过注解@FeignClient（name = "cloud-data-server", fallback= UserClientFallback.class 指向了cloud-data-server下的函数，"fallback"指向如果无法响应时的熔断器）
- 即：在请求服务器时必须传递user_key / userid （这里我设置了需要传递这些参数）

- demo (新增一个公司信息) <br/>
  + 新增公司表脚本 <br/>
  ```
  CREATE TABLE company(
    c_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    c_name VARCHAR(255) NOT NULL ,
    c_des VARCHAR(255) NOT NULL ,
    c_code VARCHAR(255) NOT NULL
  ) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
  ```
[http://localhost:7777/cloud-client-server/insertCompany](http://localhost:7777/cloud-client-server/insertCompany) <br/>
  + 请求头中必须要加 ```user_key和userid```，请```注意大小写```

- redis缓存demo <br/>
[http://localhost:7777/cloud-client-server/redisTest](http://localhost:7777/cloud-client-server/redisTest)

- activemq队列demo <br/>
[http://localhost:8077//producer/send](http://localhost:8077//producer/send)请求放入队列

- 后台管理程序（主键查询用户）<br/>
[http://127.0.0.1:7777/admin/selectUser](http://127.0.0.1:7777/admin/selectUser)

- 后台管理程序（新增用户）<br/>
[http://127.0.0.1:7777/admin/insertUser](http://127.0.0.1:7777/admin/insertUser)

- 后台管理程序（根据主键删除用户-单条）<br/>
[http://127.0.0.1:7777/admin/deleteUser](http://127.0.0.1:7777/admin/deleteUser)

- 后台管理程序（修改用户信息）<br/>
[http://127.0.0.1:7777/admin/updateUser](http://127.0.0.1:7777/admin/updateUser)

- 后台管理程序（访问首页）<br/>
[http://localhost:7777/admin/index](http://localhost:7777/admin/index)


