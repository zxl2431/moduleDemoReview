package cn.agree.test;

import java.io.File;
import java.io.IOException;

public class FileDemo01 {
    public static void main(String[] args) throws IOException {

        // 一个File对象代表硬盘中实际存在的一个文件或者目录
        /*
        *  1、构造方法 不能创建文件或者文件夹
        *
        * */

        // 文件的创建方式一: 直接指定路径
        File file1 = new File("E:\\aaa.txt");

        File file1_0 = new File("E:\\aaa");

        File file2 = new File("E:\\aaa\\bbb.txt");

        // 文件的创建方式二: 通过父路径, 子路径
        File file3 = new File("E:\\aaa", "ccc.txt");

        File file4_0 = new File("E:\\bbb");

        // 文件创建的方式三: 通过父级File对象和子路径字符串
        File fileparent = new File("E:\\bbb");
        File file4 = new File(fileparent, "a.txt");

        System.out.println("file1是否存在:"+file1.exists());
        System.out.println("file2是否存在:"+file2.exists());
        System.out.println("file3是否存在:"+file3.exists());
        System.out.println("file4是否存在:"+file4.exists());

        /*
        *  创建文件或者文件夹
        *
        * */
        file1.createNewFile();
        file1_0.mkdir();
        file2.createNewFile();
        file3.createNewFile();
        file4_0.mkdir();
        file4.createNewFile();

        System.out.println("------------创建文件之后---------------");

        System.out.println("file1是否存在:"+file1.exists());
        System.out.println("file2是否存在:"+file2.exists());
        System.out.println("file3是否存在:"+file3.exists());
        System.out.println("file4是否存在:"+file4.exists());




    }
}
