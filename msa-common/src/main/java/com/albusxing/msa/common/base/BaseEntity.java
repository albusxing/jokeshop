package com.albusxing.msa.common.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Albusxing
 * @created 2022/3/8
 */
public class BaseEntity implements Serializable {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	private Integer deleted;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
}
