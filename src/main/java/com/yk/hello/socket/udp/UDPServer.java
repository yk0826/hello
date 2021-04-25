package com.yk.hello.socket.udp;

import com.yk.hello.socket.udp.thread.UDPServerThread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP服务端
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8800);
        System.out.println("服务端已启动，正在等待客户端连接");
        int count = 0;
        while (true){
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data,0,data.length);
            socket.receive(packet);
            UDPServerThread udpServerThread = new UDPServerThread(socket,packet);
            udpServerThread.start();
            count++;
            System.out.println("当前有用户个数为："+count);
            InetAddress inetAddress = packet.getAddress();
            System.out.println("访问服务端的客户端IP为："+inetAddress.getHostAddress());
        }
    }
}
