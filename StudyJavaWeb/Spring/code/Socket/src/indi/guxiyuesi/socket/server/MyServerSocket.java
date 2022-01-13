package indi.guxiyuesi.socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 叶意
 * @ClassName MyServerSocket
 * @Description TODO
 * @createTime 2021年12月24日  22:12:00
 */
public class MyServerSocket {
    public static void main(String[] args) throws IOException {
        //监听12345端口
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("服务器端已启动!等待客户端连接...");

        //当有客户端连接时, 获取socket
        Socket socket = serverSocket.accept();
        System.out.println("客户端已连接!");

        System.out.println("客户端传来以下数据:");
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buffer)) != -1 ) {
            System.out.println(new String(buffer, 0, readLen));
        }
        inputStream.close();
        socket.close();
        System.out.println("服务端结束!");
    }
}
