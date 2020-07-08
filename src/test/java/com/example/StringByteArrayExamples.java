package com.example;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author wh
 * @date 2020/7/8
 * Description:
 */
class StringByteArrayExamples {

    public static void main(String[] args) {
        //Original String
        String string = "hello world";

        //Convert to byte[]
        byte[] bytes = string.getBytes();

        //Convert back to String
        String s = new String(bytes);

        //Check converted string against original String
        System.out.println("Decoded String : " + s);

        byte[] stringBytes = string.getBytes(StandardCharsets.UTF_8);
        String s2 = new String(stringBytes);
        System.out.println("Decoded String(utf-8) :" + s2);


        //Base64 Encoded
        String encoded = Base64.getEncoder().encodeToString(bytes);

        //Base64 Decoded
        byte[] decoded = Base64.getDecoder().decode(encoded);

        //Verify original content
        System.out.println("Decoded String(Base64) : " +new String(decoded));

    }

}
