package indi.guxiyuesi.socket.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 叶意
 * @ClassName MyClientSocket
 * @Description TODO
 * @createTime 2021年12月24日  22:29:00
 */
public class MyClientSocket {
    public static void main(String[] args) throws IOException, InterruptedException {
        //客户端向服务端发起连接
        byte[] ipAddress = new byte[4];
        ipAddress[0] = (byte) 192;
        ipAddress[1] = (byte) 168;
        ipAddress[2] = (byte) 0;
        ipAddress[3] = (byte) 22;
        Socket socket = new Socket(InetAddress.getByAddress(ipAddress), 12345);
        System.out.println("客户端发起连接!");
        //获取客户端和服务器端之间的数据通路
        OutputStream outputStream = socket.getOutputStream();
        //向数据通路中写入字节流
        System.out.println("请输入要传输给服务端的数据:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println("客户端开始写入数据!");
        outputStream.write(s.getBytes());
        //关闭socket
        socket.close();
        System.out.println("客户端结束!");
    }
}
