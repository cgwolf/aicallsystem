package com.aicallsystem.acs.util;

import com.alibaba.fastjson.JSONObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;


/**
 * <p>
 *      音频文件处理工具
 * </p>
 * @author ispong
 * @since 5/9/2019
 * @version 1.0.0
 */
public class VoiceFileUtil {

    private static final String HMAC_SHA1 = "HmacSHA1";

    /**
     * <p>
     *     访问地址编辑
     * </p>
     * @param
     * @return
     * @throws
     * @since 5/9/2019
     */
    public static String appendAuthParams() {

        StringBuilder url = new StringBuilder();
        url.append("http://asr.dui.ai/runtime/v2/").append("recognize?");

        url.append("productId=")
                .append("278581694")
                .append("&apikey=")
                .append("4a1082a3b0ea427b8fbffc01494d20bd");

        System.out.println("Url: " + url.toString());

        return url.toString();
    }

    /**
     * <p>
     *     生成Hex值
     * </p>
     * @param
     * @return
     * @throws
     * @since 5/9/2019
     */
    private static String byteToHexString(byte ib) {
        char[] Digit = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0f];
        ob[1] = Digit[ib & 0X0F];
        String s = new String(ob);
        return s;
    }

}
