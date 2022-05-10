package com.albusxing.msa.showcase.constant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author Albusxing
 * @created 2022/3/14
 */
@Data
@RefreshScope
@Component
public class DeveloperProperties {

	@Value("${developer.username}")
	private String developerName;
	@Value("${developer.email}")
	private String developerEmail;

}
