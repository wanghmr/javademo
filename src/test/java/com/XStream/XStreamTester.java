package com.XStream;

import com.example.XStreamConverter.StudentConverter;
import com.example.pojo.Student;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/**
 * @author wh
 * @date 2020/7/8
 * Description: Java对象和xml文档相互转换
 */
public class XStreamTester {
    public static void main(String[] args) {
        XStreamTester tester = new XStreamTester();
        //获取一个学生实例对象
        Student student = tester.getStudentDetails();

        //1.创建XStream 对象
        XStream xstream = new XStream(new StaxDriver());
//        XStream xstream = new XStream();
        //2.为了告诉XStream框架来处理注释，需要XML序列化之前添加下面的命令。二选一
        xstream.autodetectAnnotations(true);
//        xstream.processAnnotations(Student.class);
        //3.忽略未知字段
        xstream.ignoreUnknownElements();

        // 4.注册转换器
        xstream.registerConverter(new StudentConverter());
        // 5.Object to XML Conversion
        String xml = xstream.toXML(student);
        System.out.println("对象转化为xml："+xml);
        Student student02 = (Student) xstream.fromXML(xml);
        System.out.println("xml转化为对象："+student02.toString());
    }
    private Student getStudentDetails() {
        return new Student("中国", "世界");
    }

}


