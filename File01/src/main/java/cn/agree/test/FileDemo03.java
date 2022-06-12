package cn.agree.test;

import java.io.File;

public class FileDemo03 {
    public static void main(String[] args) {
        File file = new File("F:\\java_file\\java_middle\\Day08_File类、递归");

        // System.out.println(file.exists());

        // 获取当前目录下的文件以及文件夹名称 只是单层的
        String[] list = file.list();

        for (String name : list) {
            System.out.println(name);
        }

        System.out.println("----------获取文件或者文件夹对象------------");

        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }


    }
}
