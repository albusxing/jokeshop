package com.albusxing.msa.showcase.config;

import okhttp3.ConnectionPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.TimeUnit;

/**
 * @author Albusxing
 * @created 2022/3/12
 */
@Configuration
public class HttpClientConfig {


	@Bean
	public okhttp3.OkHttpClient okHttpClient() {
		return new okhttp3.OkHttpClient.Builder()
				.readTimeout(10, TimeUnit.SECONDS)
				.connectTimeout(10, TimeUnit.SECONDS)
				.writeTimeout(10, TimeUnit.SECONDS)
				.connectionPool(new ConnectionPool())
				.build();
	}
}
