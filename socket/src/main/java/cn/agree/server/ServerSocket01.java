package cn.agree.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket01 {
    public static void main(String[] args) throws IOException {
        System.out.println("8000端口开启监听");
        ServerSocket server = new ServerSocket(8000);
        while (true) {
            Socket socket = server.accept();
            new Thread(new Web(socket)).start();
        }






    }

    static class Web implements Runnable {
        private Socket socket;

        public Web(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                // 转换流, 读取浏览器请求的第一行
                BufferedReader readWb = new BufferedReader(new InputStreamReader(in));
                String requst = readWb.readLine();
                // System.out.println(requst);
                // 取出请求资源的路径
                String[] strArr = requst.split(" ");
                // 去掉web前面的/
                String path = strArr[1].substring(1);
                System.out.println(path);

                // 去读取客户端请求的资源
                FileInputStream fis = new FileInputStream(path);


                // 读取客户端需要的资源
                byte[] bytes = new byte[1024];
                int len = 0;
                OutputStream out = socket.getOutputStream();
                // 写入HTTP协议响应头,固定写法
                out.write("HTTP/1.1 200 OK\r\n".getBytes());
                out.write("Content‐Type:text/html\r\n".getBytes()); // 必须要写入空行,否则浏览器不解析
                out.write("\r\n".getBytes());

                while ((len=fis.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                }

                fis.close();
                out.close();
                readWb.close();
                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
