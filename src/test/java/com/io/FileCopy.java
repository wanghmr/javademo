package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wh
 * @date 2020/7/8
 * Description:
 */
public class FileCopy {

    public static void main(String[] args) {
        //一次取出的字节数大小,缓冲区大小
        byte[] buffer=new byte[512];
        int numberRead=0;
        FileInputStream input=null;
        FileOutputStream out =null;
        try {
            input=new FileInputStream("D:\\图片\\饮品.jpg");
            //如果文件不存在会自动创建
            out=new FileOutputStream("D:\\图片\\饮品2.jpg");

            //numberRead的目的在于防止最后一次读取的字节小于buffer长度，
            //否则会自动被填充0
            while ((numberRead=input.read(buffer))!=-1) {
                out.write(buffer, 0, numberRead);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (input != null) {
                    input.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
