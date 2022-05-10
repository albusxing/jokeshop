package com.albusxing.msa.account.service.impl;

import com.albusxing.msa.account.entity.User;
import com.albusxing.msa.account.mapper.UserMapper;
import com.albusxing.msa.account.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Albusxing
 * @created 2022/3/7
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	private final UserMapper userMapper;

}
