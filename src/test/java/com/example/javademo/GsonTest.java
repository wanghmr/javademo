package com.example.javademo;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wh
 * @date 2020/7/2
 * Description:Gson的用法
 */
@SpringBootTest
public class GsonTest {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class User {
        private Integer id;
        private String username;
        private String email;
    }


    /**
     * （1）基本数据类型的解析
     * (2）基本数据类型的生成
     */
    @Test
    void gsonTest01() {
        Gson gson = new Gson();
        int i = gson.fromJson("100", int.class); //100
        double d = gson.fromJson("\"99.99\"", double.class);  //99.99
        boolean b = gson.fromJson("true", boolean.class);     // true
        String str = gson.fromJson("String", String.class);   // String

        String jsonNumber = gson.toJson(100);       // 100
        String jsonBoolean = gson.toJson(false);    // false
        String jsonString = gson.toJson("String"); //"String"
    }

    /**
     * （3）POJO类的生成与解析
     */
    @Test
    void contextLoads() {
        User wh = new User(1, "wh", "1558300126@qq.com");
        Gson gson = new Gson();
        //对象转化为json串
        String req = gson.toJson(wh);
        System.out.println("对象转化为json串：" + req);

        //json串转化为对象
        User fromJson = gson.fromJson(req, User.class);
        System.out.println("json串转化为对象:" + fromJson);
    }

    /**
     * （4）基本数据类型的解析
     */
    @Test
    void gsonTest04() {
        Gson gson = new Gson();
        int i = gson.fromJson("100", int.class); //100
        double d = gson.fromJson("\"99.99\"", double.class);  //99.99
        boolean b = gson.fromJson("true", boolean.class);     // true
        String str = gson.fromJson("String", String.class);   // String
    }
}
