package com.albusxing.basis.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 开启资源服务器：@EnableResourceServer
 * 开启授权服务器：@EnableAuthorizationServer
 * @author liguoqing
 */
@EnableResourceServer
@EnableAuthorizationServer
@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
