package com.lin.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: springcloud
 * @description: 返回码枚举类
 * @author: linsz
 * @create: 2022-08-11 20:40
 **/
@Getter
@AllArgsConstructor
public enum CodeEnum {

    SUCCESS(200,"成功"),
    FAIL(444,"失败"),
    FAIL_TIMEOUT(445,"超时异常"),
    FAIL_DOWN(446,"服务器宕机"),
    UNKNOWN(447,"发生未知异常，或为服务端宕机"),
    SENTINEL_EXCEPTION(448,"sentinel熔断，openfeign统一返回处理");

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;
}
