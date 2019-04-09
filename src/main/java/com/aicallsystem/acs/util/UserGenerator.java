package com.aicallsystem.acs.util;

import java.util.UUID;

/**
 * <p>
 *      user uuid 生成器
 * </p>
 * @author ispong
 * @since 4/9/2019
 * @version 1.0.0
 */
public class UserGenerator {

    /**
     * <p>
     *     user uuid 生成器
     * </p>
     *
     * @since 4/4/2019
     */
    public static String userGenerator() {

        return "acs"+String.valueOf(UUID.randomUUID()).substring(23);
    }

}
