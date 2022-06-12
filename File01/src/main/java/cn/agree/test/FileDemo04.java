package cn.agree.test;

import java.io.File;
import java.io.FileFilter;

public class FileDemo04 {
    public static void main(String[] args) {
        File file = new File("F:\\java_file\\java_middle\\Day08_File类、递归");
        // printDir(file);
        // search(file);
        filter(file);
    }

    public static void printDir(File dir) {
        /*
        *  循环打印
        *  当是文件时, 打印绝对路径
        *  当是文件夹的时候 调用自己
        *
        * */
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名:"+file.getAbsolutePath());
            } else {
                System.out.println("目录:"+ file.getAbsolutePath());
                printDir(file);
            }
        }
    }

    public static void search(File dir) {
        File[] files = dir.listFiles();
        //
        for (File file: files) {
            if (file.isFile()) {
                if (file.getName().endsWith(".java")) {
                    System.out.println("文件名:"+file.getAbsolutePath());
                }
            } else {
                search(file);
            }
        }
    }

    public static void filter(File dir) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java")|| pathname.isDirectory();
            }
        });

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名:"+file.getAbsolutePath());
            } else {
                filter(file);
            }
        }

    }


}
