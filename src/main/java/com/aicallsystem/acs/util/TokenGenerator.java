package com.aicallsystem.acs.util;

import java.util.UUID;

/**
 * <p>
 *      token生成命令
 * </p>
 * @author ispong
 * @since 4/4/2019
 * @version 1.0.0
 */
public class TokenGenerator {


    /**
     * <p>
     *     token 生成器
     * </p>
     *
     * @since 4/4/2019
     */
    public static String tokenGenerator() {

        return String.valueOf(UUID.randomUUID()).replace("-", "");
    }

}
