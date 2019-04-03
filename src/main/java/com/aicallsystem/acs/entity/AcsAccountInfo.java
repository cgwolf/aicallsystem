package com.aicallsystem.acs.entity;

import lombok.Data;

/**
 * <p>
 *      用户验证对象
 * </p>
 * @author ispong
 * @since 4/3/2019
 * @version 1.0.0
 */
@Data
public class AcsAccountInfo {

    private String userName;

    private String password;
}
