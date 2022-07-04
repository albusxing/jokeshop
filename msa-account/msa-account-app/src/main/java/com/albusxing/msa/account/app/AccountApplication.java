package com.albusxing.msa.account.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 注册为Eureka的客户端: @EnableEurekaClient
 * @author Albusxing
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.albusxing.msa.account")
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
}
