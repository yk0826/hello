package com.yk.hello.socket.udp;

import java.io.IOException;
import java.net.*;

/**
 * UDP客户端
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        String data = "username:marry;password:123";
        int port = 8800;
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(data.getBytes(),0,data.getBytes().length,address,port);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);
        System.out.println("客户端已发送信息");

        //接受服务端传来的响应
        byte[] data1= new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data1,0,data1.length);
        socket.receive(packet1);
        System.out.println("我是客户端，接收到服务端发来的响应为："+new String(packet1.getData()));
        socket.close();
    }
}
