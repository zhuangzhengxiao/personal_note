package com.zzx.socket.demo_3_字符流;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("all")
public class DemoSocketServer_03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Socket服务端已经开启...");

        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String data = bufferedReader.readLine();
        System.out.println("服务端接受到的消息是：" + data);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello client,你的消息我已收到.");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("Socket服务端已经关闭...");
    }
}
