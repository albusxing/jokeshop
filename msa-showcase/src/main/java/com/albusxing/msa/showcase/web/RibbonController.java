package com.albusxing.msa.showcase.web;

import com.albusxing.msa.showcase.web.vm.ServiceResp;
import com.netflix.client.ClientException;
import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;
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
	private LoadBalancerClient loadBalancerClient;
	@Resource(name = "restTemplate")
	private RestTemplate restTemplate;
	@Resource(name = "loadBalancerRestTemplate")
	private RestTemplate loadBalanceRestTemplate;


	@ApiOperation(value = "testLoadBalancerClient", notes = "通过LoadBalancerClient + RestTemplate调用服务实例")
	@GetMapping("/testLoadBalancerClient")
	public String testLoadBalancerClient() {
		String serviceName = "msa-order";
		ServiceInstance serviceInstance = loadBalancerClient.choose(serviceName);
		String host = serviceInstance.getHost();
		int port = serviceInstance.getPort();
		log.info("本次调用实例：[{}]host={},port={}", serviceName, host, port);
		String url = "http://" + host + ":" + port + "/greeting/sayHello/lgq";
		String result = restTemplate.getForObject(url, String.class);
		log.info("本次调用实例返回数据:" + result);
		return result;
	}


	@ApiOperation(value = "testLoadBalanceRestTemplate", notes = "通过@LoadBalanced注解 + RestTemplate调用服务实例")
	@GetMapping("/testLoadBalanceRestTemplate")
	public String testLoadBalanceRestTemplate() {
		String url = "http://msa-order/greeting/sayHello/lgq";
		String result = loadBalanceRestTemplate.getForObject(url, String.class);
		log.info("本次调用实例返回数据:" + result);
		return result;
	}


	@ApiOperation(value = "testRestClient", notes = "测试Ribbon的原生API是如何实现负载均衡调用的")
	@GetMapping("/testRestClient")
	public void testRibbonNativeApi() throws Exception {
		// 首先使用代码的方式对ribbon进行一下配置，配置一下ribbon要调用的那个服务的server list
		ConfigurationManager.getConfigInstance().setProperty("msa-order.ribbon.listOfServers", "localhost:8010,localhost:8011");
		// 获取指定服务的RestClient，用于请求某个服务的client
		RestClient restClient = (RestClient) ClientFactory.getNamedClient("msa-order");
		// 你要请求哪个接口，构造一个对应的HttpRequest
		HttpRequest request = HttpRequest.newBuilder()
				.uri("/greeting/sayHello/lgq")
				.build();
		// 模拟请求一个接口10次
		for(int i = 0; i < 10; i++) {
			HttpResponse response = restClient.executeWithLoadBalancer(request);
			String result = response.getEntity(String.class);
			log.info("result={}", result);
		}
	}

}
