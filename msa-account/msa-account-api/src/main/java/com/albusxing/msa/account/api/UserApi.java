package com.albusxing.msa.account.api;

import com.albusxing.msa.account.domain.entity.User;
import com.albusxing.msa.common.base.BaseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Albusxing
 * @created 2022/7/3
 */
public interface UserApi {

    @ApiOperation(value = "创建用户")
    @PostMapping("/users")
    public BaseResult<Void> create(@RequestBody User user);


    @ApiOperation(value = "更新用户")
    @PutMapping("/users")
    public BaseResult<Void> update(@RequestBody User user);

    @ApiOperation(value = "获取用户详情")
    @GetMapping("/users/{id}")
    public BaseResult<User> findById(@PathVariable("id") Long id);

    @ApiOperation(value = "查询用户列表")
    @GetMapping("/users")
    public BaseResult<List<User>> listUsers(@RequestParam("gender") Integer gender,
                                            @RequestParam("age") Integer age);

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/users/{id}")
    public BaseResult<Void> deleteById(@PathVariable("id") Long id);


}
