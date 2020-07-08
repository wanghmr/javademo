package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wh
 * @date 2020/7/8
 * Description: java 处理文件的类 File
 */
public class FileExample {
    public static void main(String[] args) {
        File f = new File("D:/a/create.txt");
        //文件输入流
        InputStream streamReader = null;
        try {
            //创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
            boolean mkdirs = f.mkdirs();
            System.out.println("是否创建文件夹："+mkdirs);

            //不存在时，创建一个新的空文件。如果已存在，则不创建。父目录不存在，也无法创建。
            boolean newFile = f.createNewFile();
            System.out.println("是否创建文件："+newFile);
            System.out.println("该分区大小" + f.getTotalSpace() / (1024 * 1024 * 1024) + "G");

            //  删除此抽象路径名表示的文件或目录
            boolean delete = f.delete();
            System.out.println("是否删除文："+delete);
            //  返回由此抽象路径名表示的文件或目录的名称。
            System.out.println("文件名  " + f.getName());
            // 返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。
            System.out.println("文件父目录字符串 " + f.getParent());

            //统计文件字节长度
            int count = 0;
            streamReader = new FileInputStream(new File("D:\\图片\\饮品.jpg"));
            //读取文件字节，并递增指针到下一个字节
            while (streamReader.read() != -1) {
                count++;
            }
            System.out.println("---长度是： " + count + " 字节");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if (streamReader != null) {
                    streamReader.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
