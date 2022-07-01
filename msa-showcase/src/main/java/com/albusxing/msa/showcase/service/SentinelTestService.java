package com.albusxing.msa.showcase.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Albusxing
 * @created 2022/3/14
 */
@Slf4j
@Service
public class SentinelTestService {

	@SentinelResource(value = "sayHello", blockHandler = "blockExceptionHandler")
	public String sayHello(String name) {
		log.info("enter into say hello");
		return "Hello, " + name;
	}

	public String blockExceptionHandler(String name, BlockException ex) {
		log.info("enter into blockExceptionHandler");
		return "Oops, Block by Sentinel";
	}


	@SentinelResource("createOrder")
	public String createOrder() {
		try {
			Thread.sleep(101);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "订单已创建";
	}
}
