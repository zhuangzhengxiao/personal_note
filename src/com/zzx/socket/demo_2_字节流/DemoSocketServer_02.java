package com.zzx.socket.demo_2_字节流;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("all")
public class DemoSocketServer_02 {
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
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello client,你的消息我已收到.".getBytes());
        socket.shutdownOutput();
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("Socket服务端已经关闭...");
    }
}
