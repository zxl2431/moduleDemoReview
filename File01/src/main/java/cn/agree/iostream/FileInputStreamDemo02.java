package cn.agree.iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\testfile\\fos.txt");

        FIS1(fis);

        fis.close();
    }

    public static void FIS0(FileInputStream fis) throws IOException {
        // 定义一个变量保存数据
        int b;
        while ((b=fis.read())!= -1) {
            System.out.println((char)b);
        }
    }

    public static void FIS1(FileInputStream fis) throws IOException {
        // 定义一个变量 作为有效数据
        int len;
        // 定义字节数组 作为装字节数据的容器
        byte[] b = new byte[2];

        while ( (len=fis.read(b))!= -1) {
            System.out.println(new String(b, "utf-8"));
        }
    }



}
