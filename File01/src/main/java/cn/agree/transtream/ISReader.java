package cn.agree.transtream;

import java.io.*;

public class ISReader {
    public static void main(String[] args) throws IOException {
        // test01();
        // test02();
         test03();
    }

    public static void test01() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\testfile\\fos.txt");
        FileReader fileReader = new FileReader("E:\\testfile\\fos.txt");

        int read;
        while ((read=fis.read())!=-1) {
            System.out.println((byte) read);
        }

        fis.close();

    }

    public static void test02() throws IOException {
        FileReader fileReader = new FileReader("E:\\testfile\\aaa.txt");

        int read;
        while ((read=fileReader.read())!=-1) {
            System.out.println((char) read);
        }

        fileReader.close();

    }

    public static void test03() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\testfile\\aaa.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fis, "GBK");
        // InputStreamReader inputStreamReader = new InputStreamReader(fis);

        int read;
        while ((read=inputStreamReader.read())!=-1) {
            System.out.println((char) read);
        }

        inputStreamReader.close();

    }

}
