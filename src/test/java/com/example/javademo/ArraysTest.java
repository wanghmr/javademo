package com.example.javademo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author wh
 * @date 2020/7/1
 * Description: Arrays类的用法
 */
@SpringBootTest
public class ArraysTest {

    @Test
    void contextLoads() throws UnsupportedEncodingException {
        String message="test01";
        //将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组。
        // 注意这里包括下标from，不包括上标to。
        byte[] copyOfRange = Arrays.copyOfRange(message.getBytes("utf-8"), 0, 5);
        StringBuffer sb = new StringBuffer();
        for (byte b : copyOfRange) {
            sb.append(b + ",");
        }
        System.out.println(sb);
    }
}
