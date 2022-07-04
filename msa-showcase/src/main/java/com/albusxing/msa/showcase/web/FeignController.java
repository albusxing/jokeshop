package com.albusxing.msa.showcase.web;

import com.albusxing.msa.account.domain.entity.User;
import com.albusxing.msa.common.base.BaseResult;
import com.albusxing.msa.showcase.client.UserClient;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Albusxing
 * @created 2022/6/28
 */
@Api(tags = "Feign")
@Slf4j
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Resource
    private UserClient userClient;

    @ApiOperation(value = "获取用户列表", notes = "演示feign接口的调用流程")
    @GetMapping("/users")
    public BaseResult<List<User>> users(@RequestParam("gender") Integer gender,
                                        @RequestParam("age") Integer age) {
        return userClient.listUsers(gender, age);
    }
}
