package com.example.javademo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author wh
 * @date 2020/7/1
 * Description: Arrays类的用法--Arrays.copyOfRange
 */
@SpringBootTest
class ArraysTest {

    @Test
    void contextLoads() {
        String message = "test01";
        //将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组。
        // 注意这里包括下标from，不包括上标to。
        byte[] copyOfRange = Arrays.copyOfRange(message.getBytes(UTF_8), 0, 5);
        StringBuffer sb = new StringBuffer();
        for (byte b : copyOfRange) {
            sb.append(b).append(",");
        }
        System.out.println(sb);
    }
}
