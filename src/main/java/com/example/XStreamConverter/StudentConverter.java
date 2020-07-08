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
 * Description:
 */
public class StudentConverter implements Converter {

    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer,
                        MarshallingContext context) {
        Student student = (Student) value;
        writer.startNode("name");
        writer.setValue(student.getName().getFirstName() + ","
                + student.getName().getLastName());
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader,
                            UnmarshallingContext context) {
        reader.moveDown();
        String[] nameparts = reader.getValue().split(",");
        Student student = new Student(nameparts[0], nameparts[1]);
        reader.moveUp();
        return student;
    }

    @Override
    public boolean canConvert(Class object) {
        return object.equals(Student.class);
    }
}