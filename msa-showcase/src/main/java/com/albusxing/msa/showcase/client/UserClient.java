package com.albusxing.msa.showcase.client;

import com.albusxing.msa.showcase.client.dto.UserDto;
import com.albusxing.msa.showcase.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * OpenFeign 通信客户端： @FeignClient
 * @author Albusxing
 * @created 2022/3/12
 */
@FeignClient(name = "msa-account", configuration = FeignConfig.class)
public interface UserClient {


	@GetMapping("/getUserById")
	UserDto getUserById(@RequestParam("userId") Long userId);

    @PostMapping("/saveUser")
    void saveUser(UserDto user);
}
