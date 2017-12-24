# 基于spring boot的spring-session-demo
1. pom.xml中加入
```
    <dependency>
        <groupId>org.springframework.session</groupId>
        <artifactId>spring-session</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
```
2. 分别启动两个实例部署在8080（/app1）和8081(/app2)端口
3. 在浏览器中localhost:8080/app1/add/123/abc
4. 使用app1的Cookie去app2中访问localhost:8081/app2/get/123可看到在app1的Session中保存的值
