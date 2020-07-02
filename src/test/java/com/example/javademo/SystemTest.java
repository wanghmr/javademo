package com.example.javademo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * @author wh
 * @date 2020/7/1
 * Description: System类的用法
 */
class SystemTest {

    /**
     * System.arraycopy
     */
    @Test
    void contextLoads() {
        //初始化对象数组 
        User[] users = new User[]{
                new User(1, "admin", "admin@qq.com"),
                new User(2, "maco", "maco@qq,com"),
                new User(3, "kitty", "kitty@qq,com")};
        //新建一个目标对象数组
        User[] target = new User[users.length];
        //实现复制
        System.arraycopy(users, 0, target, 0, users.length);
        System.out.println("源对象与目标对象的物理地址是否一样：" + (users[0] == target[0] ? "浅复制" : "深复制"));
        target[0].setEmail("admin@sina.com");
        System.out.println("修改目标对象的属性值后源对象users：");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class User {
        private Integer id;
        private String username;
        private String email;
    }
}
