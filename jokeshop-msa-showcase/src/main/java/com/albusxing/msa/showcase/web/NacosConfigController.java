package com.albusxing.msa.showcase.web;

import com.albusxing.msa.showcase.constant.DeveloperProperties;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Albusxing
 * @created 2022/3/15
 */
@Api(tags = "Nacos配置中心")
@RestController
@RequestMapping("/nacos-config")
public class NacosConfigController {

	@Value("${app.name}")
	private String appName;
	@Value("${app.version}")
	private String appVersion;
	@Resource
	private DeveloperProperties developerProperties;


	@GetMapping(value = "/getAppConfig")
	public String getAppConfig() {
		return "appName:" + appName + ", appVersion:" + appVersion;
	}

	@GetMapping(value = "/getDevConfig")
	public String getDevConfig() {
		return "devName:" + developerProperties.getDeveloperName() + ", devEmail:" + developerProperties.getDeveloperEmail();
	}


}
