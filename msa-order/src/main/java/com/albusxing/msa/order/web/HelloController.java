package com.albusxing.msa.order.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

/**
 * @author Albusxing
 * @created 2022/5/30
 */
@RestController
public class HelloController {

    @Resource
    private RestTemplate restTemplate;

    private static final String GOODS_SERVICE_NAME = "msa-goods";

    @GetMapping(value = "/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://localhost:8020/sayHello/" + name, String.class);
    }
}
