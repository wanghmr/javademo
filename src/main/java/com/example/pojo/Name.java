package com.example.pojo;

/**
 * @author wh
 * @date 2020/7/8
 * Description:
 */
public class Name {
    private String firstName;
    private String lastName;

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}

