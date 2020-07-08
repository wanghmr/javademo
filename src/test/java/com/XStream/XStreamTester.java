package com.XStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/**
 * @author wh
 * @date 2020/7/8
 * Description: Java对象和xml文档相互转换
 */
public class XStreamTester {
    public static void main(String args[]) {
        XStreamTester tester = new XStreamTester();
        //获取一个学生实例对象
        Student student = tester.getStudentDetails();

        //创建XStream 对象
        XStream xstream = new XStream(new StaxDriver());
        //为了告诉XStream框架来处理注释，需要XML序列化之前添加下面的命令。二选一
        xstream.autodetectAnnotations(true);
//        xstream.processAnnotations(Student.class);
        // 注册转换器
        xstream.registerConverter(new StudentConverter());
        // Object to XML Conversion
        String xml = xstream.toXML(student);
        System.out.println(xml);
    }

    private Student getStudentDetails() {
        Student student = new Student("Mahesh", "Parashar");
        return student;
    }

}

@XStreamAlias("student")
class Student {

    @XStreamAlias("name")
    private Name studentName;

    public Student(String firstName, String lastName) {
        this.studentName = new Name(firstName, lastName);
    }

    public Name getName() {
        return studentName;
    }
}

class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
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

class StudentConverter implements Converter {

    public void marshal(Object value, HierarchicalStreamWriter writer,
                        MarshallingContext context) {
        Student student = (Student) value;
        writer.startNode("name");
        writer.setValue(student.getName().getFirstName() + ","
                + student.getName().getLastName());
        writer.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader reader,
                            UnmarshallingContext context) {
        reader.moveDown();
        String[] nameparts = reader.getValue().split(",");
        Student student = new Student(nameparts[0], nameparts[1]);
        reader.moveUp();
        return student;
    }

    public boolean canConvert(Class object) {
        return object.equals(Student.class);
    }
}
