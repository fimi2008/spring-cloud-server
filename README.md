# spring-cloud-server
Spring Cloud 微服务搭建

登录http://start.spring.io/ ，生成Spring项目

# eureka-server
    Eureka服务器
    Eureka用于微服务注册和发现的工具
    启动命令： mvn: spring-boot:run
    访问：localhost:1111
    
# bookingcar
    EurekaClient的实现
    在Eureka服务器上注册服务
    在Eureka管理界面Application下查看注册服务
    访问：localhost:{port}/v1/user/1
    
# ribbon-service
    负载均衡
    访问：localhost:{port}/v1/lb/testport?name=bookingcar-service
    
# zuul-service
    服务网关
    访问：localhost:{port}/loadbalance-service/v1/lb/testport?name=bookingcar-service
    
# reports
     如何内部调用
    
