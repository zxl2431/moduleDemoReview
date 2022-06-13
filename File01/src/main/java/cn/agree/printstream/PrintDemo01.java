package cn.agree.printstream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintDemo01 {
    public static void main(String[] args) throws FileNotFoundException {
        // 调用系统打印流 控制台输出
        System.out.println(97);

        // 创建打印流 指定文件的名称
        PrintStream ps = new PrintStream("E:\\ps.txt");

        System.setOut(ps);

        System.out.println(97);





    }
}
