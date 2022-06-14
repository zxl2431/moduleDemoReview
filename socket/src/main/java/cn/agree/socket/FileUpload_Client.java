package cn.agree.socket;

import java.io.*;
import java.net.Socket;

public class FileUpload_Client {
    public static void main(String[] args) throws IOException {
        //
        System.out.println("客户端已经启动");
        Socket client = new Socket("localhost", 6666);
        // 输入流 从硬盘读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\testfile\\client\\pic.jpg"));
        // 输出流 传给服务器
        BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());

        byte[] buff = new byte[8*1024];
        int len;

        while ((len=bis.read(buff))!=-1) {
            bos.write(buff, 0, len);
            // System.out.println(buff);
            bos.flush();
        }

        // 发送完成以后要关流
        client.shutdownOutput();

        System.out.println("文件发送完毕");

        // 解析回写
        InputStream inputStream = client.getInputStream();
        byte[] back = new byte[20];
        inputStream.read(back);
        System.out.println(new String(back));

        bos.close();
        bis.close();
        client.close();

    }
}
