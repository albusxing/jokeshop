package com.albusxing.basis.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义的全局过滤器，用来记录请求的响应时间
 *
 * @author Albusxing
 * @created 2022/3/12
 */
@Slf4j
@Component
public class ElapsedFilter implements GlobalFilter, Ordered {

	/**
	 * 起始时间属性名
	 */
	private static final String ELAPSED_TIME_BEGIN = "elapsedTimeBegin";

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
					Long startTime = exchange.getAttribute(ELAPSED_TIME_BEGIN);
					if (startTime != null) {
						log.info(exchange.getRequest().getRemoteAddress()
								+ " | " + exchange.getRequest().getPath()
								+ " | cost " + (System.currentTimeMillis() - startTime) + "ms");
					}
				})
		);
	}


	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}

}
