package com.albusxing.msa.showcase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Albusxing
 * @created 2022/3/10
 */
@EnableOpenApi
@Configuration
public class Swagger3Config {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.OAS_30)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.albusxing.msa.showcase.web"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("msa-showcase")
				.description("msa-showcase")
				.version("1.0.0")
				.build();
	}
}
