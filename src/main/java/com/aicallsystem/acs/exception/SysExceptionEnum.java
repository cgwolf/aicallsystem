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
