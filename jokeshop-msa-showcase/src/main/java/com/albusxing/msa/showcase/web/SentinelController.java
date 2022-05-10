package com.albusxing.msa.showcase.web;

import com.albusxing.msa.showcase.service.SentinelTestService;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Albusxing
 * @created 2022/3/14
 */
@Api(tags = "Sentinel")
@Slf4j
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

	@Resource
	private SentinelTestService sentinelTestService;

	@ApiOperation(value = "helloWorld")
	@GetMapping("/hello-world")
	public String helloWorld() {
		initFlowRules();
		try (Entry entry = SphU.entry("HelloWorld")) {
			// 被保护的逻辑
			log.info("hello world");
			return "Hello world";
		} catch (BlockException e) {
			// 处理被流控的逻辑
			log.info("blocked!");
			return "blocked";
		}

	}

	/**
	 * 限制每秒最多1个请求
	 */
	private static void initFlowRules() {
		List<FlowRule> rules = new ArrayList<>();
		FlowRule rule = new FlowRule();
		rule.setResource("HelloWorld");
		rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
		// Set limit QPS to 1.
		rule.setCount(1);
		rules.add(rule);
		FlowRuleManager.loadRules(rules);
	}


	@GetMapping(value = "/hello/{name}")
	public String sayHello(@PathVariable String name) {
		return sentinelTestService.sayHello(name);
	}



	@ApiOperation(value = "测试流控")
	@GetMapping("/test-flow-rule")
	public String testFlowRule() {
		return "success";
	}

	@ApiOperation(value = "测试降级")
	@GetMapping("/test-degrade-rule")
	public String testDegradeRule(){
		try {
			sentinelTestService.createOrder();
		} catch (IllegalStateException e) {
			return e.getMessage();
		}
		return "success";
	}

}
