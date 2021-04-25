package com.yk.hello.socket.tcp.thread;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String data = "";
            while ((data=bufferedReader.readLine())!=null){
                System.out.println("我是服务器，接收到客户端发来的信息： "+data);
            }
            socket.shutdownInput();
            //响应客户端
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("欢迎你登录！");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (printWriter!=null)
                    printWriter.close();
                if (outputStream!=null)
                    outputStream.close();
                if (bufferedReader!=null)
                    bufferedReader.close();
                if (inputStreamReader!=null)
                    inputStreamReader.close();
                if (inputStream!=null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
