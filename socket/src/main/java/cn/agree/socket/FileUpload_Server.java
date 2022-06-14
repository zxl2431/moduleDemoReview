package cn.agree.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUpload_Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动...");
        ServerSocket serverSocket = new ServerSocket(6666);
        // while(true) 一直循环 解决保存一个文件就关闭的问题
        while (true) {
            Socket server = serverSocket.accept();

            // 多线程 同时对付多个客户端
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 输入流, 读取客户端传过来的数据
                        BufferedInputStream bis = new BufferedInputStream(server.getInputStream());
                        // 输出流, 保存到硬盘
                        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\testfile\\server\\"+System.currentTimeMillis()+ ".jpg"));

                        // 输出流 输出到客户端
                        OutputStream outputStream = server.getOutputStream();

                        byte[] buff = new byte[8*1024];
                        int len;
                        while ((len=bis.read(buff))!=-1) {
                            bos.write(buff, 0, len);
                            // System.out.println(buff);
                        }



                        System.out.println("文件已经上传");

                        // 信息回写
                        outputStream.write("上传成功".getBytes());
                        outputStream.close();

                        bos.close();
                        bis.close();
                        server.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }).start();



        }





    }
}
