package com.albusxing.msa.showcase.web;

import com.albusxing.msa.showcase.client.UserClient;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Albusxing
 * @created 2022/6/28
 */
@Api(tags = "Feign")
@Slf4j
@RestController
@RequestMapping("/feign")
@RequiredArgsConstructor
public class FeignController {

    private final UserClient userClient;


    @ApiOperation(value = "获取注册中心的服务列表")
    @GetMapping("/users")
    public List<ServiceInstance> users() {
        return Lists.newArrayList();
    }
}
