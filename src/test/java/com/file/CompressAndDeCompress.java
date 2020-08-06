package com.file;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author wh
 * @date 2020/8/5
 * Description: 压缩文件与解压缩
 */
public class CompressAndDeCompress {

    public static void main(String[] args) {
        //压缩
//        compress("D://test.zip", "D://图片");

        //解压
        decompress("D://test.zip", "D://test2/");
    }

    /**
     * 解压缩
     *
     * @param targetZip
     * @param parent
     */
    private static void decompress(String targetZip, String parent) {

        try {
            //构造输入流
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(targetZip));
            ZipEntry zipEntry = null;
            File file = null;
            while ((zipEntry = zipInputStream.getNextEntry()) != null && !zipEntry.isDirectory()) {
                String entryName = zipEntry.getName();
                String substring = entryName.substring(entryName.lastIndexOf("/"));
                file = new File(parent,substring);
                if (!file.exists()) {
                    //创建此文件的上级目录
                    new File(file.getParent()).mkdirs();
                }
                System.out.println("------------" + file);
                FileOutputStream out = new FileOutputStream(file);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
                byte[] bytes = new byte[1024];
                int length;
                while ((length = zipInputStream.read(bytes)) != -1) {
                    bufferedOutputStream.write(bytes);
                }
                out.close();
                bufferedOutputStream.close();
                System.out.println("解压缩成功...");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void compress(String zipPath, String targetPath) {
        File file = new File(targetPath);
        ZipOutputStream zipOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(zipPath));
            bufferedOutputStream = new BufferedOutputStream(zipOutputStream);
            zip(zipOutputStream, bufferedOutputStream, zipPath, file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert zipOutputStream != null;
                zipOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert bufferedOutputStream != null;
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 压缩文件
     *
     * @param zipOutputStream      zip输出流
     * @param bufferedOutputStream buff输出流
     * @param zipPath              压缩的zip路径
     * @param file                 待压缩的目标文件
     * @throws IOException 异常
     */
    private static void zip(ZipOutputStream zipOutputStream, BufferedOutputStream bufferedOutputStream, String zipPath, File file) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            //空文件夹
            if (files.length == 0) {
                zipOutputStream.putNextEntry(new ZipEntry(zipPath + "/"));
            }
            for (File f : files) {
                zip(zipOutputStream, bufferedOutputStream, zipPath + "/" + f.getName(), f);
            }
        } else {
            zipOutputStream.putNextEntry(new ZipEntry(zipPath));
            FileInputStream in = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
            byte[] bytes = new byte[1024];
            int length = -1;
            while ((length = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, length);
            }
            in.close();
            bufferedInputStream.close();
        }
    }
}
