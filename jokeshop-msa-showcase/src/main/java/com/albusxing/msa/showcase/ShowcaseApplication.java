package com.albusxing.msa.showcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * 开启注册中心客户端：@EnableDiscoveryClient}、@EnableEurekaClient
 * 开发声明式Feign调用
 * @author Albusxing
 * @created 2022/3/7
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ShowcaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowcaseApplication.class, args);
	}
}
