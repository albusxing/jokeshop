package com.albusxing.msa.goods.entity;

import com.albusxing.msa.common.base.BaseEntity;

import java.io.Serializable;

/**
 * @author Albusxing
 * @created 2022/3/12
 */
public class GoodsStock extends BaseEntity {

	private Long goodsId;
	private Long skuId;
	private String title;
	private Integer quantity;
	private String unit;
	private String description;
}
