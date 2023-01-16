package top.novashen.demo02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {
    public static void main(String[] args) throws IOException {

        //建立连接，打开io流
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();

        //打开文件(流)
        FileOutputStream fos = new FileOutputStream("demo02.jpg");

        //将io流写入文件流
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1) {
            fos.write(buffer,0,len);
        }

        //关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }
}
