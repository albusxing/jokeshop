package com.albusxing.basis.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * 跨域配置
 */
public class CorsConfig {


//    @Bean
//    public CorsWebFilter corsFilter() {
//        CorsConfiguration config = new CorsConfiguration();
//        //允许所有请求方法跨域调用
//        config.addAllowedMethod("*");
//        //允许所有域名进行跨域调用
//        config.addAllowedOrigin("*");
//        //放行全部原始头信息
//        config.addAllowedHeader("*");
//        //允许跨越发送cookie
//        config.setAllowCredentials(true);
//        CorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
//        source.registerCorsConfiguration("/**", config);
//        return new CorsWebFilter(source);
//    }
}
