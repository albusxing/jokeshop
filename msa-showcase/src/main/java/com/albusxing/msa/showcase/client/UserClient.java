package com.albusxing.msa.showcase.client;

import com.albusxing.msa.account.api.UserApi;
import com.albusxing.msa.showcase.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * OpenFeign 通信客户端： @FeignClient
 * @author Albusxing
 * @created 2022/3/12
 */
@FeignClient(name = "msa-account", configuration = FeignConfig.class)
public interface UserClient extends UserApi  {


}
