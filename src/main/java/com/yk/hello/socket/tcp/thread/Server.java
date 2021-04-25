package com.yk.hello.socket.tcp.thread;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("***服务端已启动，等待客户端进行连接***");
            Socket socket = null;
            int count=0;
            while (true) {
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("当前访问服务端的客户端数量为：" + count);
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("访问服务端的客户端IP为："+inetAddress.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
