package com.albusxing.msa.account.app.service.impl;


import com.albusxing.msa.account.app.service.UserService;
import com.albusxing.msa.account.domain.entity.User;
import com.albusxing.msa.account.domain.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Albusxing
 * @since 2022-07-01
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
