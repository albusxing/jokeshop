package com.albusxing.msa.account.entity;

import com.albusxing.msa.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author Albusxing
 * @created 2022/3/7
 */
@Data
@TableName("t_users")
public class User extends BaseEntity {

	private String username;
	private String password;
	private Integer gender;
	private Integer age;
	private String phone;
	private String address;

}
