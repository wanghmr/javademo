package com.document;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * @author wh
 * @date 2020/8/13
 * Description:
 */
public class DomDemo {
    public static void main(String[] args) {
        //获取xml路径
        ClassPathResource pathResource = new ClassPathResource("school.xml");
        ClassPathResource insertPath = new ClassPathResource("insertSchool.xml");
//        System.out.println("=== ===" + pathResource);
//        System.out.println("===getPath===" + pathResource.getPath());
//        try {
//            System.out.println("===getURL===" + pathResource.getURL());
//            System.out.println("===getFile===" + pathResource.getFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //读取xml文件
        DomDemo.queryXml(pathResource);
        //插入
        DomDemo.insertXml(pathResource, insertPath);
    }

    /**
     * 遍历xml文档
     *
     * @param pathResource 读取的文件路径
     */
    private static void queryXml(ClassPathResource pathResource) {
        try {
            //得到DOM解析器的工厂实例
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //从DOM工厂中获得DOM解析器
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            //把要解析的xml文档读入DOM解析器
            Document document = documentBuilder.parse(pathResource.getFile());
            //得到文档名称为Student的元素的节点列表
            NodeList studentNodes = document.getElementsByTagName("Student");
            System.out.println("----NodeList-----" + studentNodes);
            //遍历该集合，显示结合中的元素及其子元素的名字
            for (int i = 0; i < studentNodes.getLength(); i++) {
                Element node = (Element) studentNodes.item(i);
                System.out.println("Name: " + node.getElementsByTagName("Name").item(0).getFirstChild().getNodeValue());
                System.out.println("Num: " + node.getElementsByTagName("Num").item(0).getFirstChild().getNodeValue());
                System.out.println("Classes: " + node.getElementsByTagName("Classes").item(0).getFirstChild().getNodeValue());
                System.out.println("Address: " + node.getElementsByTagName("Address").item(0).getFirstChild().getNodeValue());
                System.out.println("Tel: " + node.getElementsByTagName("Tel").item(0).getFirstChild().getNodeValue());
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向已存在的xml文件中插入元素
     *
     * @param pathResource 读取的文件路径
     */
    private static void insertXml(ClassPathResource pathResource, ClassPathResource insertPath) {
        Element school;
        Element student;
        Element name;
        Element num;
        Element classes;
        Element address;
        Element tel;
        try {
            //得到DOM解析器的工厂实例
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            //从DOM工厂中获得DOM解析器
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            //把要解析的xml文档读入DOM解析器
            Document doc = dbBuilder.parse(pathResource.getFile());
            //得到文档名称为Student的元素的节点列表
            NodeList nList = doc.getElementsByTagName("School");
            school = (Element) nList.item(0);

            //创建名称为Student的元素
            student = doc.createElement("Student");
            //设置元素Student的属性值为231
            student.setAttribute("examId", "23");
            //创建名称为Name的元素
            name = doc.createElement("Name");
            //创建名称为 香香 的文本节点并作为子节点添加到name元素中
            name.appendChild(doc.createTextNode("香香"));
            //将name子元素添加到student中
            student.appendChild(name);

            //下面的元素依次加入即可
            num = doc.createElement("Num");
            num.appendChild(doc.createTextNode("1006010066"));
            student.appendChild(num);

            classes = doc.createElement("Classes");
            classes.appendChild(doc.createTextNode("眼视光5"));
            student.appendChild(classes);

            address = doc.createElement("Address");
            address.appendChild(doc.createTextNode("浙江温州"));
            student.appendChild(address);

            tel = doc.createElement("Tel");
            tel.appendChild(doc.createTextNode("123890"));
            student.appendChild(tel);

            //将student作为子元素添加到树的根节点school
            school.appendChild(student);

            // 创建TransformerFactory对象
            TransformerFactory tff = TransformerFactory.newInstance();
            // 创建 Transformer对象
            Transformer tf = tff.newTransformer();
            // 输出内容是否使用换行
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            // 创建xml文件并写入内容
            tf.transform(new DOMSource(doc), new StreamResult(new File(insertPath.getPath())));
            System.out.println("生成book1.xml成功");
            System.out.println("成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
