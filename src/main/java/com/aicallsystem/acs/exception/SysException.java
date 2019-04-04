package com.aicallsystem.acs.exception;

import lombok.Data;

/**
 * <p>
 *      系统异常
 * </p>
 * @author ispong
 * @since 4/3/2019
 * @version 1.0.0
 */
@Data
public class SysException extends RuntimeException{

    private final String description;

    public SysException (SysExceptionEnum sysExceptionEnum) {

        this.description = sysExceptionEnum.getDescription();

    }
}
