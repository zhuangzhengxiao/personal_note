package com.zzx.socket.demo_2_字节流;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings("all")
public class DemoSocketClient_02 {
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 9999);
            System.out.println("Socket客户端已经连接成功...");
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我们已经连接成功，可以随时随地发送数据...".getBytes());
            socket.shutdownOutput();// 没有这一行的话，就不知道什么时候结束

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.println("从socket服务端接收到的消息是 ： " + new String(bytes));
            }
            inputStream.close();
            outputStream.close();
            socket.close();
            System.out.println("Socket客户端已经断开连接.");
        } catch (Exception e) {
            System.out.println("Socket连接失败...");
        }

    }
}
