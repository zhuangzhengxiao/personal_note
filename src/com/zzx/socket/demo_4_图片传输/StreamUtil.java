package com.zzx.socket.demo_4_图片传输;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {
    /**
     * 将传入的输入流，转换成字节数组  byetes Array
     * @param in 输入流
     * @return bytes[]
     * @throws IOException
     */
    public static byte[] tobyteArrays(InputStream in) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = in.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
