package com.albusxing.msa.showcase.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Albusxing
 * @created 2022/2/26
 */
@Api(tags = "Discovery")
@Slf4j
@RestController
@RequestMapping("/discovery")
@RequiredArgsConstructor
public class DiscoveryController {

	private final DiscoveryClient discoveryClient;

	@ApiOperation(value = "获取注册中心的服务列表")
	@GetMapping("/services")
	public List<ServiceInstance> getServiceInstances() {
		List<ServiceInstance> allServiceInstances = new ArrayList<>();
		// 获取注册中心所有的服务列表
		List<String> serviceIds = discoveryClient.getServices();
		for (String serviceId : serviceIds) {
			List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
			allServiceInstances.addAll(instances);
		}
		return allServiceInstances;
	}

}
