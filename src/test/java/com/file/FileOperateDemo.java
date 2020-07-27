package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wh
 * @date 2020/7/27
 * Description: java操作文件
 */
public class FileOperateDemo {

    /**
     * 复制文件或文件夹
     * 文件分隔符为 “//”
     */
    public static boolean copyGeneralFile(String strPath, String destDir) throws IOException {
        boolean flag = false;
        File file = new File(strPath);
        if (!file.exists()) {
            System.out.println("源文件或源文件夹不存在");
            return false;
        }
        if (file.isFile()) {
            System.out.println("下面进行文件复制");
            flag = copyFile(strPath, destDir);
        } else if (file.isDirectory()) {
            System.out.println("下面进行文件夹赋值");
            flag = copyDirectory(strPath, destDir);
        }
        return flag;
    }

    /*
    复制文件
    */
    private static boolean copyFile(String srcPath, String destDir) throws IOException {
        boolean flag = false;
        File fileSrc = new File(srcPath);
        if (!fileSrc.exists()) {
            System.out.println("源文件不存在");
            return false;
        }
        String fileName = srcPath.substring(srcPath.lastIndexOf(File.separator));
        String destPath = destDir + fileName;
        if (destPath.equals(srcPath)) {
            System.out.println("源文件和目标文件路径重复");
            return false;
        }
        File destFile = new File(destPath);
        if (destFile.exists() && destFile.isFile()) {
            System.out.println("目标目录已有同名文件");
            return false;
        }
        File destFileDir = new File(destDir);
        destFileDir.mkdirs();
        try {
            FileInputStream fis = new FileInputStream(fileSrc);
            FileOutputStream fos = new FileOutputStream(destFileDir);
            byte[] buf = new byte[1024];
            int c;
            while ((c = fis.read(buf)) != -1) {
                fos.write(buf, 0, c);
            }
            fis.close();
            fos.close();
            flag = true;
        } catch (IOException e) {
            throw e;
        }
        if (flag) {
            System.out.println("文件复制成功");
        }
        return flag;
    }

    /**
     * 复制文件夹
     */
    private static boolean copyDirectory(String srcPath, String destDir) throws IOException {
        System.out.println("复制文件夹");
        boolean flag = false;
        File srcFile = new File(srcPath);
        if (!srcFile.exists()) {
            System.out.println("源文件夹不存在");
            return false;
        }
        //获得复制的文件夹的名字
        String dirName = getDirName(srcPath);
        //目标文件夹的完成路径
        String destPath = destDir + File.separator + dirName;
        if (destPath.equals(srcPath)) {
            System.out.println("目标文件夹与源文件夹重复");
            return false;
        }
        File destDirFile = new File(destPath);
        if (destDirFile.exists()) {
            System.out.println("目标位置已有同名文件夹");
            return false;
        }
        destDirFile.mkdirs();
        File[] fileList = srcFile.listFiles();
        if (fileList.length == 0) {
            flag = true;
        } else {
            for (File tmp : fileList) {
                if (tmp.isFile()) {
                    flag = copyFile(tmp.getAbsolutePath(), destPath);
                } else if (tmp.isDirectory()) {
                    flag = copyDirectory(tmp.getAbsolutePath(), destPath);
                }
                if (!flag) {
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("赋值文件夹成功");
        }
        return flag;
    }

    /**
     * 获取待复制的文件夹名
     */
    private static String getDirName(String dir) {
        if (dir.endsWith(File.separator)) {
            dir = dir.substring(0, dir.lastIndexOf(File.separator));
        }
        return dir.substring(dir.lastIndexOf(File.separator) + 1);
    }


    /**
     * 删除文件或文件夹
     */
    public static boolean deleteGeneralFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("需要删除的文件不存在");
        }
        if (file.isDirectory()) {
            flag = deleteDirectory(file.getAbsolutePath());
        } else if (file.isFile()) {
            flag = deleteFile(file);
        }
        if (flag) {
            System.out.println("删除成功");
        }
        return flag;
    }


    /**
     * 删除文件
     */
    private static boolean deleteFile(File file) {
        return file.delete();
    }

    /**
     * 删除目录及其下面的所有子文件和子文件夹,如果目录下还有其他文件或是文件夹，直接调用delete方法无效，必须待其子文件或子文件夹删除才可
     */
    private static boolean deleteDirectory(String path) {
        boolean flag = true;
        File dirFile = new File(path);
        if (!dirFile.isDirectory()) {
            return flag;
        }
        File[] files = dirFile.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                flag = deleteFile(file);
            } else if (file.isDirectory()) {
                flag = deleteDirectory(file.getAbsolutePath());
            }

            //只要有一个不成功就不再继续
            if (!flag) {
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) throws IOException {
        String srcPath = "D:/AA";
        String destDir = "D:/BB";

        copyGeneralFile(srcPath, destDir);

        deleteGeneralFile(srcPath);

    }
}
