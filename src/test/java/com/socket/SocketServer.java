package com.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wh
 * @date 2020/7/15
 * Description: socket服务端
 */
public class SocketServer {
    public static void main(String[] args) throws Exception {
        // 创建服务端
        ServerSocket server = new ServerSocket(8081);

        // 服务端阻塞式监听客户端连接请求
        // 接收到连接请求，则创建一个socket实例，与客户端通信
        Socket client = server.accept();

        // 获取InputStream读取数据
        InputStream in = client.getInputStream();
        byte[] b = new byte[1024];
        // 客户端关闭输出流后服务端会读取到-1标志
        while(-1 != in.read(b))
        {
            System.out.println(new String(b));
        }

        // 获取OutputStream输出数据
        OutputStream out = client.getOutputStream();
        out.write("hello, client".getBytes());
        // 输出结束，关闭输出流
        client.shutdownOutput();

        System.out.println("Server close. " + System.currentTimeMillis());
        server.close();
    }
}
