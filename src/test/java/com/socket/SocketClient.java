package com.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author wh
 * @date 2020/7/15
 * Description: socket客户端
 */
public class SocketClient {
    public static void main(String[] args) throws Exception {
        // 请求连接服务端，握手成功，返回Socket实例
        Socket client = new Socket("127.0.0.1",8081);

        // 获取输入输出流，读写数据（与服务端数据读写操作相同）
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();

        out.write("hello, server".getBytes());
        client.shutdownOutput();

        byte[] b = new byte[1024];
        while(-1 != in.read(b)) {
            System.out.println(new String(b));
        }

        System.out.println("Client close. " + System.currentTimeMillis());
        client.close();
    }
}
