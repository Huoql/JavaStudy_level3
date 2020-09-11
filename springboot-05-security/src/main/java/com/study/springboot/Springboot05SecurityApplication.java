package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.引入Spring Security：
 * 2.编写Spring Security的配置类
 * 	继承WebSecurityConfigurerAdapter，添加@EnableWebSecurity注解
 * 3.控制请求的访问权限
 */
@SpringBootApplication
public class Springboot05SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot05SecurityApplication.class, args);
	}

}
