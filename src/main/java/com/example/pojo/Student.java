package com.example.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author wh
 * @date 2020/7/8
 * Description:
 */
@XStreamAlias("student")
public class Student {

    @XStreamAlias("name")
    private Name studentName;

    public Name getName() {
        return studentName;
    }

    public Student(String firstName, String lastName) {
        this.studentName = new Name(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Student{"+studentName.getFirstName()+","+studentName.getLastName()+"}";
    }
}

