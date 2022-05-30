//package com.albusxing.msa.showcase.config;
//
//import com.netflix.client.config.IClientConfig;
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author Albusxing
// * @created 2022/3/8
// */
//@Configuration
//public class LoadBalanceConfig {
//
//	@Autowired
//	private IClientConfig config;
//
//	@Bean
//	@ConditionalOnMissingBean
//	public IRule springHealthRule(IClientConfig config) {
//		return new RandomRule();
//	}
//}
