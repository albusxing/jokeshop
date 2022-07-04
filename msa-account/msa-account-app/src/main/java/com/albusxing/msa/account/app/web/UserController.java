package com.albusxing.msa.account.app.web;


import com.albusxing.msa.account.app.service.UserService;
import com.albusxing.msa.account.domain.entity.User;
import com.albusxing.msa.common.base.BaseResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Albusxing
 * @since 2022-07-01
 */
@Api(tags = "用户管理")
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "创建用户")
    @PostMapping("/users")
    public BaseResult<Void> create(@RequestBody @Valid User user) {
        userService.save(user);
        return BaseResult.success();
    }


    @ApiOperation(value = "更新用户")
    @PutMapping("/users")
    public BaseResult<Void> update(@RequestBody @Valid User user) {
        userService.save(user);
        return BaseResult.success();
    }

    @ApiOperation(value = "获取用户详情")
    @GetMapping("/users/{id}")
    public BaseResult<User> findById(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        return BaseResult.success(user);
    }

    @ApiOperation(value = "查询用户列表")
    @GetMapping("/users")
    public BaseResult<List<User>> listUsers(@RequestParam("gender") Integer gender,
                                            @RequestParam("age") Integer age) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("gender", gender);
        queryWrapper.eq("age", age);
        List<User> users = userService.list(queryWrapper);
        return BaseResult.success(users);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/users/{id}")
    public BaseResult<Void> deleteById(@PathVariable("id") Long id) {
        userService.removeById(id);
        return BaseResult.success();
    }
}
