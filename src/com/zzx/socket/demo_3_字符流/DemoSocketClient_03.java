package com.zzx.socket.demo_3_字符流;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings("all")
public class DemoSocketClient_03 {
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 9999);
            System.out.println("Socket客户端已经连接成功...");
            OutputStream outputStream = socket.getOutputStream();

            // 通过Writer写字符数据
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("开始字符流数据的传输。");
            bufferedWriter.newLine();// 加上这行表示结束。 同理，服务端要接收消息，也要使用bufferReader.readLine()来接收数据。
            bufferedWriter.flush(); // 将数据写入通道

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String data = bufferedReader.readLine();
            System.out.println("从socket服务端接收到的消息是 ： " + data);

            bufferedReader.close();
            bufferedWriter.close();
            inputStream.close();
            outputStream.close();
            socket.close();
            System.out.println("Socket客户端已经断开连接.");
        } catch (Exception e) {
            System.out.println("Socket连接失败...");
        }

    }
}
