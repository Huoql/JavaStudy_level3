package com.study.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 * 1.配置eureka相关信息
 * 2.添加@EnableEurekaServer 注解
 */
@EnableEurekaServer
@SpringBootApplication
public class Springboot06SpringcloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot06SpringcloudEurekaApplication.class, args);
	}

}
