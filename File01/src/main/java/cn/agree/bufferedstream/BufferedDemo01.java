package cn.agree.bufferedstream;

import java.io.*;

public class BufferedDemo01 {
    public static void main(String[] args) throws IOException {
        // 记录开始的时间
        long start = System.currentTimeMillis();
        // fileInputStream和fileOutputStream的速度测试
        // testFS();
        // testFS_buf();
        // testBufferStream();
        // testBufferStream_buff();
        // testBufferReader();
        // testBufferReader_buff();
        testReadLine();
        long end = System.currentTimeMillis();

        System.out.println("耗时是:"+(end-start)+"毫秒!");
    }

    public static void testFS() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\tomcat.zip");
        FileOutputStream fos = new FileOutputStream("E:\\testfile\\tomcat_bak.zip");

        int b;
        while ((b=fis.read())!= -1) {
            fos.write(b);
        }

        fos.close();
        fis.close();
    }

    public static void testFS_buf() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\tomcat.zip");
        FileOutputStream fos = new FileOutputStream("E:\\testfile\\tomcat_bak.zip");

        byte[] buff = new byte[1024];

        int len;
        while ((len=fis.read(buff))!= -1) {
            fos.write(buff, 0, len);
        }

        fos.close();
        fis.close();
    }

    public static void testBufferStream() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\tomcat.zip"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\testfile\\tomcat_bak.zip"));

        int b;
        while ((b=bis.read()) != -1) {
            bos.write(b);
        }

        bis.close();
        bos.close();
    }

    public static void testBufferStream_buff() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\tomcat.zip"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\testfile\\tomcat_bak.zip"));

        byte[] buff = new byte[8*1024];
        int b;
        while ((b=bis.read(buff)) != -1) {
            bos.write(buff, 0, b);
        }

        bis.close();
        bos.close();
    }

    public static void testBufferReader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\tomcat.zip"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\testfile\\tomcat_bak.zip"));

        int len;

        while ((len=bufferedReader.read())!=-1) {
            bufferedWriter.write(len);
        }

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static void testBufferReader_buff() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\tomcat.zip"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\testfile\\tomcat_bak.zip"));

        char[] buff = new char[1024];
        int len;

        while ((len=bufferedReader.read(buff))!=-1) {
            bufferedWriter.write(buff, 0, len);
        }

        bufferedReader.close();
        bufferedWriter.close();
    }


    public static void testReadLine() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\read.txt"));

        String line = null;

        while ((line=bufferedReader.readLine())!=null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }


}
