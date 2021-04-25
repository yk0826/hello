package com.yk.hello.socket.udp.thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 实现多客户端UDP连接
 */
public class UDPServerThread extends Thread{

    private DatagramSocket socket;

    private DatagramPacket packet;

    public UDPServerThread(DatagramSocket socket,DatagramPacket packet){
        this.socket=socket;
        this.packet = packet;
    }

    @Override
    public void run() {
        InetAddress address = packet.getAddress();
        System.out.println("服务器收到客户端发来的请求，IP为："+address.getHostAddress());
        String info = new String(packet.getData(),0,packet.getData().length);
        System.out.println("收到的请求为："+info);

        //响应客户端
        byte[] data2 = "服务器已收到信息，欢迎登陆".getBytes();
        DatagramPacket packet1 = new DatagramPacket(data2,0,data2.length,address,packet.getPort());
        try {
            socket.send(packet1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
