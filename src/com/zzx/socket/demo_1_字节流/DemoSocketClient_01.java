package com.zzx.socket.demo_1_字节流;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings("all")
public class DemoSocketClient_01 {
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 9999);
            System.out.println("Socket客户端已经连接成功...");
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我们已经连接成功，可以随时随地发送数据...".getBytes());
            outputStream.close();
            socket.close();
            System.out.println("Socket客户端已经断开连接.");
        } catch (Exception e) {
            System.out.println("Socket连接失败...");
        }

    }
}
