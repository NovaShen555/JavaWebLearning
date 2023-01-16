package top.novashen.demo02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //建立连接，打开io流，打开文件(流)
        Socket socket = new Socket(Inet4Address.getByName("127.0.0.1"),9999);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("ttest.jpg");
        // 将文件(流)写入io流
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        //关闭资源
        fis.close();
        os.close();
        socket.close();


    }
}
