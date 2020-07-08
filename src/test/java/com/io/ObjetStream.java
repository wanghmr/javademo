package com.io;

import java.io.*;

/**
 * @author wh
 * @date 2020/7/8
 * Description:
 */
public class ObjetStream {
    public static void main(String[] args) {
        // TODO自动生成的方法存根
        ObjectOutputStream objectwriter = null;
        ObjectInputStream objectreader = null;

        try {
            objectwriter = new ObjectOutputStream(new FileOutputStream("D:/a/student.txt"));
            objectwriter.writeObject(new Student("gg", 22));
            objectwriter.writeObject(new Student("tt", 18));
            objectwriter.writeObject(new Student("rr", 17));
            objectreader = new ObjectInputStream(new FileInputStream("D:/a/student.txt"));
            for (int i = 0; i < 3; i++) {
                System.out.println(objectreader.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            // TODO自动生成的 catch 块
            e.printStackTrace();
        } finally {
            try {
                if (objectreader != null) {
                    objectreader.close();
                }
                if (objectwriter != null) {
                    objectwriter.close();
                }
            } catch (IOException e) {
                // TODO自动生成的 catch 块
                e.printStackTrace();
            }

        }

    }

}

class Student implements Serializable {
    private String name;
    private int age;

    Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }


}
