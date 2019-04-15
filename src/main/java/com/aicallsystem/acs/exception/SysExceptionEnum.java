package com.aicallsystem.acs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *      系统异常枚举类型
 * </p>
 * @author ispong
 * @since 4/4/2019
 * @version 1.0.0
 */
@AllArgsConstructor
public enum SysExceptionEnum {

    /**
     *  权限获取失败
     */
    GET_PERMISSION_ERROR("权限获取失败"),

    /**
     *  token失效
     */
    TOKEN_ERROR("请重新登录！"),

    /**
     *  创建用户账号失败
     */
    CREATE_ACCOUNT_ERROR("创建用户账号失败"),

    /**
     *  生成Token失败
     */
    GENERATOR_TOKEN_ERROR("生成Token失败"),

    /**
     *  删除联系方式失败
     */
    DELETE_CONTACT_ERROR("删除联系方式失败"),

    /**
     *  添加联系方式失败
     */
    ADD_CONTACT_ERROR("添加联系方式失败"),

    /**
     *  身份验证失败
     */
    AUTH_ERROR("身份验证失败");

    @Setter
    @Getter
    private String description;
}
