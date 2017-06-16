package com.demo.utils;

import java.io.File;

/**
 * 标题：文件工具类
 * 作者：zc741
 * 版本：
 * 创建时间：on 2017/6/16 14:36
 */
public class FileUtil {

    /**
     * 创建目录
     *
     * @param path
     * @return
     * @throws Exception
     */
    public static boolean createDir(String path) throws Exception {
        File file = new File(path);
        return file.mkdir();
    }

    /**
     * 删除目录
     *
     * @param path
     * @return
     * @throws Exception
     */
    public static boolean deleteDir(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            file.delete();
            return false;
        }
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            deleteDir(files[i].getAbsolutePath());
        }
        file.delete();

        return file.delete();
    }

    /**
     * 递归删除所有文件/目录
     *
     * @param dirpath
     */
    public void deleteAll(String dirpath) {
        if (dirpath == null) {
            System.out.println("目录为空");
        } else {
            File path = new File(dirpath);
            try {

                if (!path.exists()) {
                    return;// 目录不存在
                }
                if (path.isFile()) {
                    path.delete();
                    return;
                }
                File[] files = path.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteAll(files[i].getAbsolutePath());
                }
                path.delete();
            } catch (Exception e) {
                System.out.println("文件删除失败");
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除文件夹
     * @param folderPath
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); // 删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); // 删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);// 再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }
}
