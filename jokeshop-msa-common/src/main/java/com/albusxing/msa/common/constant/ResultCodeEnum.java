package com.albusxing.msa.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通用返回码枚举
 * 0 成功
 * 1 失败
 * @author liguoqing
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {

    /**
     * 返回结果定义
     */
    SUCCESS(0, "成功"),
    ERROR(1, "失败");

    private Integer code;
    private String message;


}
