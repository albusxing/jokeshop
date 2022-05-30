package com.albusxing.msa.account.web;

import com.albusxing.msa.account.entity.User;
import com.albusxing.msa.account.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Albusxing
 * @created 2022/2/25
 */
@Api(tags = "用户管理")
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@ApiOperation(value = "创建用户")
	@PostMapping("/users")
	public ResponseEntity<Void> create(@RequestBody @Valid User user) {
		userService.save(user);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "获取用户详情")
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Long id) {
		User user = userService.getById(id);
		return ResponseEntity.ok().body(user);
	}

	@ApiOperation(value = "查询用户列表")
	@GetMapping("/users")
	public ResponseEntity<List<User>> listUsers() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
		List<User> result = userService.list(queryWrapper);
		return ResponseEntity.ok().body(result);
	}

	@ApiOperation(value = "删除用户")
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
		userService.removeById(id);
		return ResponseEntity.ok().build();
	}


}
