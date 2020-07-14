package com.utils8583;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Base64;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author wh
 * @date 2020/7/14
 * Description:
 */
public class Base64Util {
    /**
     * 编码字符串
     * @param str
     * @return
     */
    public static String encode(String str, String encoding){
        if(StringUtils.isEmpty(str)) return "";
        if(StringUtils.isEmpty(encoding)){
            encoding = CharEncoding.UTF_8;
        }
        try {
            return Base64.encodeBase64String(str.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 解码字符串
     * @param str
     * @return
     */
    public static String decode(String str, String encoding){
        if(StringUtils.isEmpty(str)) return "";
        if(StringUtils.isEmpty(encoding)){
            encoding = CharEncoding.UTF_8;
        }
        try {
            return new String(Base64.decodeBase64(str), encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
