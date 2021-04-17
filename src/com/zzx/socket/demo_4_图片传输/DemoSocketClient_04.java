package com.zzx.socket.demo_4_图片传输;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings("all")
public class DemoSocketClient_04 {
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 9999);
            String path = "C:\\Users\\mi\\Desktop\\test.png";
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
            byte[] bytes = StreamUtil.tobyteArrays(bufferedInputStream); // 图片的二进制流

            // 通过socket 将 字节数组上传到服务端
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(bytes);
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            byte[] result = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(result)) != -1) {
                System.out.println("收到服务端的回复：" + new String(result));
            }
            inputStream.close();
            bufferedInputStream.close();
            outputStream.close();
            socket.close();
            System.out.println("Socket客户端已经断开连接.");
        } catch (Exception e) {
            System.out.println("Socket连接失败...");
        }
    }
}
