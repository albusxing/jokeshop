package com.albusxing.msa.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Albusxing
 * @created 2022/3/8
 */
@Configuration
public class RestTemplateConfig {

	/**
	 * 开启负载均衡
	 * @return
	 */
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
