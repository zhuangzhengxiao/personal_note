package com.zzx.socket.demo_1_字节流;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("all")
public class DemoSocketServer_01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Socket服务端已经开启...");

        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println("接受到的消息是 ： " + new String(bytes));
        }
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("Socket服务端已经关闭...");
    }
}
