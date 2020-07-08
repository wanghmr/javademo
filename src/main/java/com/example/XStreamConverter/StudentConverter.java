package com.example.XStreamConverter;

import com.example.pojo.Student;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * @author wh
 * @date 2020/7/8
 * Description: XStream自定义转换器
 */
public class StudentConverter implements Converter {

    /**
     * 序列化对象到XML。
     *
     * @param value
     * @param writer
     * @param context
     */
    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer,
                        MarshallingContext context) {
        Student student = (Student) value;
        writer.startNode("name");
        writer.setValue(student.getName().getFirstName() + ","
                + student.getName().getLastName());
        writer.endNode();
    }


    /**
     * 从XML对象反序列化
     *
     * @param reader
     * @param context
     * @return
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader reader,
                            UnmarshallingContext context) {
        reader.moveDown();
        String[] nameparts = reader.getValue().split(",");
        Student student = new Student(nameparts[0], nameparts[1]);
        reader.moveUp();
        return student;
    }

    /**
     * 检查支持的对象类型的序列化。
     *
     * @param object
     * @return
     */
    @Override
    public boolean canConvert(Class object) {
        return object.equals(Student.class);
    }
}