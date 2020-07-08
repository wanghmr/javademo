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

        byte[] bytes = string.getBytes();
        String s = new String(bytes);
        System.out.println("Decoded String : " + s);

        byte[] stringBytes = string.getBytes(StandardCharsets.UTF_8);
        String s2 = new String(stringBytes,StandardCharsets.UTF_8);
        System.out.println("Decoded String(utf-8) :" + s2);

        if (bytes != null && bytes.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : bytes) {
                // 以十六进制输出
                stringBuilder.append(String.format("%X", b));
            }
            System.out.println("hello hex：" + stringBuilder);
        }

        //Base64 Encoded
        String encoded = Base64.getEncoder().encodeToString(bytes);
        //Base64 Decoded
        byte[] decoded = Base64.getDecoder().decode(encoded);
        //Verify original content
        System.out.println("Decoded String(Base64) : " +new String(decoded));

    }

}
