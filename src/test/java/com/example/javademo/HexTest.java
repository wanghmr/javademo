package com.example.javademo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author wh
 * @date 2020/6/30
 * Description: Hex类的用法
 * 使用Apache的Hex类实现Hex(16进制字符串和)和字节数组的互转，导入commons-codec依赖
 */
@SpringBootTest
@Slf4j
class HexTest {
    @Test
    void hexTest() {
        String str = "f2345678909866555";
        log.info("String类型解码成byte[]类型");
        String substring = str.substring(0, 10);
        //1234567890
        System.out.println("substring:" + substring);
        try {
            //十六进制字符串（Hex）转字节数字（byte[]）
            byte[] decodeHex = Hex.decodeHex(substring);
            //[B@5e9bbd9d
            System.out.println("decodeHex(Hex.decodeHex):" + Arrays.toString(decodeHex));

            //字节数组（byte[]）转为十六进制（Hex）字符串
            String encodeHexString = Hex.encodeHexString(decodeHex);
            System.out.println("encodeHexString:" + encodeHexString);
        } catch (DecoderException e) {
            e.printStackTrace();
        }
    }

    @Test
    void hexTest02() {
        String str = "test";
        //编码
        //第一种方式：直接一步到位
        String hexString = Hex.encodeHexString(str.getBytes(StandardCharsets.UTF_8));
        System.out.println(hexString);
        //第二种方式：先转换成char数组，第二个参数意思是是否全部转换成小写
        char[] encodeHex = Hex.encodeHex(str.getBytes(), true);
        System.out.println(new String(encodeHex));

        //解码
        //第一种方式：入的是cha字符串类型的，该方法要求传r[]
        try {
            byte[] decodeHex2 = Hex.decodeHex(hexString.toCharArray());
            System.out.println(new String(decodeHex2));
            //第二种方式：char数组型的
            byte[] decodeHex = Hex.decodeHex(encodeHex);
            System.out.println(new String(decodeHex));
        } catch (DecoderException e) {
            e.printStackTrace();
        }

    }


}
