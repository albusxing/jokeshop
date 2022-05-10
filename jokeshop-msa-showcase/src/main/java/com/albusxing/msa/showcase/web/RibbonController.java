package com.albusxing.msa.showcase.web;

import com.albusxing.msa.showcase.web.vm.ServiceResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Albusxing
 * @created 2022/2/26
 */
@Api(tags = "Ribbon")
@Slf4j
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

	@Resource
	private DiscoveryClient discoveryClient;

	/**
	 * 注入 Ribbon 负载均衡器对象
	 */
	@Resource
	private LoadBalancerClient loadBalancerClient;

	@Resource(name = "restTemplate")
	private RestTemplate restTemplate;

	@Resource(name = "loadBalancerRestTemplate")
	private RestTemplate loadBalanceRestTemplate;



	@ApiOperation(value = "获取注册中心的服务列表")
	@GetMapping("/services")
	public ServiceResp getServices() {
		List<ServiceInstance> allServiceInstances = new ArrayList<>();
		// 获取注册中心所有的服务列表
		List<String> serviceIds = discoveryClient.getServices();
		String description = discoveryClient.description();
		for (String serviceId : serviceIds) {
			List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
			allServiceInstances.addAll(instances);
		}
		ServiceResp serviceResp = ServiceResp.builder()
				.description(description)
				.serviceInstances(allServiceInstances)
				.build();
		return serviceResp;
	}

	@ApiOperation(value = "负载均衡的方式调用Account服务", notes = "通过LoadBalancerClient + RestTemplate调用服务实例")
	@GetMapping("/accounts")
	public String getAccountServices() {
		String accountServiceName = "msa-account";
		ServiceInstance serviceInstance = loadBalancerClient.choose(accountServiceName);
		String host = serviceInstance.getHost();
		int port = serviceInstance.getPort();
		log.info("本次调用实例：[{}]host={},port={}", accountServiceName, host, port);
		String url = "http://" + host + ":" + port + "/users";
		String result = restTemplate.getForObject(url, String.class);
		log.info("本次调用实例返回数据:" + result);
		return result;
	}


	@ApiOperation(value = "负载均衡的方式调用Account服务", notes = "通过@LoadBalanced + RestTemplate调用服务实例")
	@GetMapping("/accounts2")
	public String getAccountServices2() {
		String url = "http://msa-account/users";
		String result = restTemplate.getForObject(url, String.class);
		log.info("本地调用实例返回数据:" + result);
		return result;
	}

}
