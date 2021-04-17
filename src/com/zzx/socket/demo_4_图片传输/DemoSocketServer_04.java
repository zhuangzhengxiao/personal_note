package com.zzx.socket.demo_4_图片传输;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 完成图片上传到服务器功能，
 * 并向客户端发送收到的消息
 */
@SuppressWarnings("all")
public class DemoSocketServer_04 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Socket服务端已经开启...正在准备接收图片...");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = StreamUtil.tobyteArrays(inputStream); // 获得图片上传的字节数组

        // 1.将接收到的图片进行存储
        String path = "src\\xia.png";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
        bufferedOutputStream.write(bytes);
        System.out.println("已成功接收到图片。");

        // 2.向客户端发送接收成功的消息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("接收成功".getBytes());
        socket.shutdownOutput();

        outputStream.close();
        inputStream.close();
        bufferedOutputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("Socket服务端已经关闭...");
    }
}
