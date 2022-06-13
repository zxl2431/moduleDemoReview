package cn.agree.socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动, 等待连接...");
        // 1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(6666);
        // 2.接收连接accept方法 只有accept方法才能获取到 Socket
        Socket server = serverSocket.accept();

        InputStream is = server.getInputStream();

        byte[] buff = new byte[1024];
        int len = is.read(buff);

        // 解析数组
        String msg = new String(buff, 0, len);

        System.out.println(msg);
        // 数据回写
        OutputStream out = server.getOutputStream();
        out.write("我是服务端,很好, 你好吗?".getBytes());

        out.close();
        is.close();
        server.close();


    }
}
