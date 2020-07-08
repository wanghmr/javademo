package com.XStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

import java.io.Writer;

/**
 * @author wh
 * @date 2020/7/8
 * Description: XStream支持JSON通过初始化XStream对象适当的驱动程序。
 * XStream目前支持JettisonMappedXmlDriver和JsonHierarchicalStreamDriver。
 */
public class XStreamJsonTester {

    public static void main(String[] args) {
        Student student = new Student("Mahesh", "Parashar");

        XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
            public HierarchicalStreamWriter createWriter(Writer writer) {
                return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
            }
        });
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("student", Student.class);
        System.out.println(xstream.toXML(student));
    }
}

@XStreamAlias("student")
class Student {

    private String firstName;
    private String lastName;

    Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return "Student [ firstName: " + firstName + ", lastName: " + lastName
                + " ]";
    }
}
