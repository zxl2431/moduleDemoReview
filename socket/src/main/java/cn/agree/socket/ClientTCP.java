package cn.agree.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端 发送数据");

        Socket client = new Socket("localhost", 6666);

        OutputStream os = client.getOutputStream();

        os.write("你好啊, tcp, 我来了".getBytes());

        // 接收响应
        InputStream is = client.getInputStream();
        byte[] buff = new byte[1024];
        int len;
        len = is.read(buff);

        if (len!=-1) {
            System.out.println(new String(buff, 0, len));
        }

        is.close();
        os.close();
        client.close();
    }
}
