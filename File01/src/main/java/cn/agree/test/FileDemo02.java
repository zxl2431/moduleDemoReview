package cn.agree.test;

import java.io.File;

public class FileDemo02 {
    public static void main(String[] args) {
        File file1 = new File("E:/ccc/bbb.java");
        System.out.println("文件的绝对路径:"+ file1.getAbsolutePath());
        System.out.println("文件的构造路径:"+file1.getPath());
        System.out.println("文件名称:"+ file1.getName());
        System.out.println("文件长度:"+file1.length()+"字节");


    }
}
